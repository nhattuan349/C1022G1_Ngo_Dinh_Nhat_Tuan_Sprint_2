package com.example.be.dto;

import com.example.be.model.Orders;
import com.example.be.model.Product;

import java.time.LocalDateTime;

public interface IOrderDetailDto {
    Long getOrderDerailId();
    Integer getAmount();
    Long getOrderId();
    Long getProductId();
    Long getAccountId();
    String getName();
    String getProductName();
    String getProductImage();
    Integer getProductPromotionalPrice();
    Integer getProductQuantity();
    LocalDateTime getOrderProductTime();
    Boolean getFlagBuy();

}
