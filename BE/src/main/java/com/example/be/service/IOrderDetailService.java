package com.example.be.service;

import com.example.be.dto.IOrderDetailDto;
import com.example.be.model.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOrderDetailService {

    void saveOrderDetail(OrderDetail orderDetail);

    Page<IOrderDetailDto> findAllDetailDto(@Param("id") Long id, Pageable pageable);

    void increaseQuantity(@Param("id") Long id);

    void decreaseQuantity(@Param("id") Long id);

    void removeOrderDetail(@Param("id") Long id);

    List<IOrderDetailDto> findAllListDetailDto(@Param("accountId") Long accountId);

    OrderDetail findByIdOrderDetail(Long orderDerailId);

    OrderDetail getOrderDetailFindById(@Param("orderDerailId") Long orderDerailId);

    void updateBuySuccess(@Param("accountId") Long accountId);

    Page<IOrderDetailDto> findAllPurchaseHistory(@Param("id") Long id,Pageable pageable);

    IOrderDetailDto getTotal(@Param("id") Long id);

    List<IOrderDetailDto> amountShoppingCart(@Param("id") Long id);
}
