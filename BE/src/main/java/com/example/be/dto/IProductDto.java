package com.example.be.dto;

import com.example.be.model.ProductType;

public interface IProductDto {
    Long getProductId();
    String getProductCode();
    Integer getProductQuantity();
    String getProductName();
    Integer getProductPrice();
    String getDescription();
    String getProductImage();
    Integer getProductPromotionalPrice();
    Boolean getProductFlagDelete();
    ProductType getProductType();
    String getProductTypeName();
}
