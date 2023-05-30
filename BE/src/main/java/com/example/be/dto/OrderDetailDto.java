package com.example.be.dto;

import com.example.be.model.Orders;
import com.example.be.model.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class OrderDetailDto implements Validator {
    private Long orderDerailId;
    private Integer amount;
    private Product product;
    private Orders orders;

    public OrderDetailDto() {
    }

    public OrderDetailDto(Long orderDerailId, Integer amount, Product product, Orders orders) {
        this.orderDerailId = orderDerailId;
        this.amount = amount;
        this.product = product;
        this.orders = orders;
    }

    public Long getOrderDerailId() {
        return orderDerailId;
    }

    public void setOrderDerailId(Long orderDerailId) {
        this.orderDerailId = orderDerailId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
