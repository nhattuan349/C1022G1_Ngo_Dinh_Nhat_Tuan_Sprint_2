package com.example.be.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    private String productCode;
    private Integer productQuantity;
    private String productName;
    private Integer productPrice;
    private String description;
    private String productImage;
    private Integer productPromotionalPrice;
    private Boolean productFlagDelete;


    @ManyToOne
    @JoinColumn(name = "product_type_id",referencedColumnName = "product_type_id")
    @JsonBackReference
    private ProductType productType;



    public Product() {
    }

    public Product(Long productId, String productCode, Integer productQuantity, String productName, Integer productPrice, String description, String productImage, Integer productPromotionalPrice, Boolean productFlagDelete, ProductType productType) {
        this.productId = productId;
        this.productCode = productCode;
        this.productQuantity = productQuantity;
        this.productName = productName;
        this.productPrice = productPrice;
        this.description = description;
        this.productImage = productImage;
        this.productPromotionalPrice = productPromotionalPrice;
        this.productFlagDelete = productFlagDelete;
        this.productType = productType;
    }

    public Product(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Integer getProductPromotionalPrice() {
        return productPromotionalPrice;
    }

    public void setProductPromotionalPrice(Integer productPromotionalPrice) {
        this.productPromotionalPrice = productPromotionalPrice;
    }

    public Boolean getProductFlagDelete() {
        return productFlagDelete;
    }

    public void setProductFlagDelete(Boolean productFlagDelete) {
        this.productFlagDelete = productFlagDelete;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }




}
