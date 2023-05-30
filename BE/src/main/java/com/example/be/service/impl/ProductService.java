package com.example.be.service.impl;

import com.example.be.dto.IProductDto;
import com.example.be.dto.IProductImage;
import com.example.be.model.Product;
import com.example.be.repository.IProductRepository;
import com.example.be.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;


    @Override
    public Page<IProductDto> findAllProductDto(String keySearch1, Pageable pageable) {
        return productRepository.findAllProductDto(keySearch1, pageable);
    }

    @Override
    public Page<IProductDto> findAllPriceProductDto(String minPrice, String maxPrice, Pageable pageable) {
        return productRepository.findAllPriceProductDto(minPrice, maxPrice, pageable);
    }

    @Override
    public Product findProductDetailById(int id) {
        return productRepository.findProductDetailById(id);
    }

    @Override
    public List<IProductImage> getProductImageList(int id) {
        return productRepository.getProductImageList(id);
    }



}
