package com.example.be.controller;


import com.example.be.dto.OrdersDto;
import com.example.be.model.Orders;
import com.example.be.service.IOrdersService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/orders")
public class OrdersRestController {


    @Autowired
    private IOrdersService ordersService;

    @PostMapping("/create-orders")
    public ResponseEntity createDocument(@Valid @RequestBody OrdersDto ordersDto, BindingResult bindingResult) {
        ordersDto.validate(ordersDto, bindingResult);
        if (ordersDto == null || bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Orders orders = new Orders();
        BeanUtils.copyProperties(ordersDto, orders);
        ordersService.saveOrders(orders);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
