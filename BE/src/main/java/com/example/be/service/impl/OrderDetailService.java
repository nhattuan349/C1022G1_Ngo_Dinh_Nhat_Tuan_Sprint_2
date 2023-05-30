package com.example.be.service.impl;

import com.example.be.dto.IOrderDetailDto;
import com.example.be.model.OrderDetail;
import com.example.be.repository.IOrderDetailRepository;
import com.example.be.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService {

    @Autowired
    private IOrderDetailRepository orderDetailRepository;

    @Override
    public void saveOrderDetail(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
    }

    @Override
    public Page<IOrderDetailDto> findAllDetailDto(Long id, Pageable pageable) {
        return orderDetailRepository.findAllDetailDto(id, pageable);
    }

    @Override
    public void increaseQuantity(Long id) {
        orderDetailRepository.increaseQuantity(id);
    }

    @Override
    public void decreaseQuantity(Long id) {
        orderDetailRepository.increaseQuantity(id);
    }

    @Override
    public void removeOrderDetail(Long id) {
        orderDetailRepository.removeOrderDetail(id);
    }

    @Override
    public List<IOrderDetailDto> findAllListDetailDto(Long accountId) {
        return orderDetailRepository.findAllListDetailDto(accountId);
    }

    @Override
    public OrderDetail findByIdOrderDetail(Long orderDerailId) {
        return orderDetailRepository.findById(orderDerailId).orElse(null);
    }

    @Override
    public OrderDetail getOrderDetailFindById(Long orderDerailId) {
        return orderDetailRepository.getOrderDetailFindById(orderDerailId);
    }

    @Override
    public void updateBuySuccess(Long accountId) {
        orderDetailRepository.updateBuySuccess(accountId);
    }

    @Override
    public Page<IOrderDetailDto> findAllPurchaseHistory(Long id, Pageable pageable) {
        return orderDetailRepository.findAllPurchaseHistory(id, pageable);
    }

    @Override
    public IOrderDetailDto getTotal(Long id) {
        return orderDetailRepository.getTotal(id);
    }

    @Override
    public List<IOrderDetailDto> amountShoppingCart(Long id) {
        return orderDetailRepository.amountShoppingCart(id);
    }

}
