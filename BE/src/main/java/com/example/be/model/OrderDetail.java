package com.example.be.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private Long orderDerailId;
    private Integer amount;
    private Boolean flagDelete;
    @Column(columnDefinition = "dateTime")
    private LocalDateTime orderProductTime;
    private Boolean flagBuy;
    @ManyToOne
    @JoinColumn(name = "product_id" , referencedColumnName = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id" , referencedColumnName = "order_id")
    private Orders orders;

    public OrderDetail() {
    }

    public OrderDetail(Long orderDerailId, Integer amount, Product product, Orders orders) {
        this.orderDerailId = orderDerailId;
        this.amount = amount;
        this.product = product;
        this.orders = orders;
    }

    public OrderDetail(Long orderDerailId, Integer amount, Boolean flagDelete, Product product, Orders orders) {
        this.orderDerailId = orderDerailId;
        this.amount = amount;
        this.flagDelete = flagDelete;
        this.product = product;
        this.orders = orders;
    }

    public OrderDetail(Long orderDerailId, Integer amount, Boolean flagDelete, LocalDateTime orderProductTime, Boolean flagBuy, Product product, Orders orders) {
        this.orderDerailId = orderDerailId;
        this.amount = amount;
        this.flagDelete = flagDelete;
        this.orderProductTime = orderProductTime;
        this.flagBuy = flagBuy;
        this.product = product;
        this.orders = orders;
    }

    public OrderDetail(Long orderDerailId, Integer amount, Boolean flagDelete, LocalDateTime orderProductTime, Product product, Orders orders) {
        this.orderDerailId = orderDerailId;
        this.amount = amount;
        this.flagDelete = flagDelete;
        this.orderProductTime = orderProductTime;
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

    public Boolean getFlagDelete() {
        return flagDelete;
    }

    public LocalDateTime getOrderProductTime() {
        return orderProductTime;
    }

    public void setOrderProductTime(LocalDateTime orderProductTime) {
        this.orderProductTime = orderProductTime;
    }

    public Boolean getFlagBuy() {
        return flagBuy;
    }

    public void setFlagBuy(Boolean flagBuy) {
        this.flagBuy = flagBuy;
    }

    public void setFlagDelete(Boolean flagDelete) {
        this.flagDelete = flagDelete;
    }
}
