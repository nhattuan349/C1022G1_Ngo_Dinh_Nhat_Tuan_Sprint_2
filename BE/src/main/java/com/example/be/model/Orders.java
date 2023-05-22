package com.example.be.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;
    private String orderCode;
    private Date orderDate;
    private Boolean orderFlagDelete;
    private String deliveryStatus;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "account_id",referencedColumnName = "account_id")
    @JsonBackReference
    private Account account;

    public Orders() {
    }

    public Orders(Long orderId, String orderCode, Date orderDate, Boolean orderFlagDelete, String deliveryStatus, Integer quantity, Account account) {
        this.orderId = orderId;
        this.orderCode = orderCode;
        this.orderDate = orderDate;
        this.orderFlagDelete = orderFlagDelete;
        this.deliveryStatus = deliveryStatus;
        this.quantity = quantity;
        this.account = account;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Boolean getOrderFlagDelete() {
        return orderFlagDelete;
    }

    public void setOrderFlagDelete(Boolean orderFlagDelete) {
        this.orderFlagDelete = orderFlagDelete;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
