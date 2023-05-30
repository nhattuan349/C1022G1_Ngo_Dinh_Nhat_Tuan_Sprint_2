package com.example.be.service.impl;

import com.example.be.model.Orders;
import com.example.be.repository.IOrdersRepository;
import com.example.be.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService implements IOrdersService {

    @Autowired
    private IOrdersRepository ordersRepository;

    @Override
    public void saveOrders(Orders orders) {
        ordersRepository.save(orders);
    }
}
