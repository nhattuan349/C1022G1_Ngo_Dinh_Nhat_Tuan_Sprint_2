package com.example.be.service;

import com.example.be.dto.IProductDto;
import com.example.be.dto.IProductImage;
import com.example.be.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductService {

    Page<IProductDto> findAllProductDto(
            @Param("keySearch1") String keySearch1,
            Pageable pageable);

    Page<IProductDto> findAllPriceProductDto(
            @Param("minPrice") String minPrice,
            @Param("maxPrice") String maxPrice,
            Pageable pageable);

    Product findProductDetailById(@Param("id") int id);

    List<IProductImage> getProductImageList(@Param("id") int id);


}
