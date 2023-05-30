package com.example.be.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

public class OrdersDto implements Validator {
    private Long orderId;
    private String orderCode;
    private Date orderDate;
    private Boolean orderFlagDelete;
    private String deliveryStatus;
    private Integer quantity;

    public OrdersDto() {
    }

    public OrdersDto(Long orderId, String orderCode, Date orderDate, Boolean orderFlagDelete, String deliveryStatus, Integer quantity) {
        this.orderId = orderId;
        this.orderCode = orderCode;
        this.orderDate = orderDate;
        this.orderFlagDelete = orderFlagDelete;
        this.deliveryStatus = deliveryStatus;
        this.quantity = quantity;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
