package com.example.be.controller;

import com.example.be.dto.IProductDto;
import com.example.be.dto.IProductImage;
import com.example.be.model.Product;
import com.example.be.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/product")
public class ProductRestController {

    @Autowired
    private IProductService productService;

    @GetMapping("")
    public ResponseEntity<Page<IProductDto>> getAllAndSearchDocument(
            @RequestParam(defaultValue = "", required = false) String keySearch1,
            @PageableDefault(value = 12) Pageable pageable) {
        Page<IProductDto> productDto = productService.findAllProductDto(keySearch1, pageable);
        if (productDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @GetMapping("/price")
    public ResponseEntity<Page<IProductDto>> getAllAndSearchDocument(
            @RequestParam(defaultValue = "", required = false) String minPrice,
            @RequestParam(defaultValue = "", required = false) String maxPrice,
            @PageableDefault(value = 12) Pageable pageable) {
        Page<IProductDto> productDto = productService.findAllPriceProductDto(minPrice,maxPrice, pageable);
        if (productDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @GetMapping("findProductById/{id}")
    public ResponseEntity<Product> detailTicket(@PathVariable("id") int id) {
        Product product = productService.findProductDetailById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<List<IProductImage>> getAccompanyingImageList(@PathVariable("id") int id) {
        List<IProductImage> productImage = productService.getProductImageList(id);
        if (productImage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productImage, HttpStatus.OK);
    }

}
