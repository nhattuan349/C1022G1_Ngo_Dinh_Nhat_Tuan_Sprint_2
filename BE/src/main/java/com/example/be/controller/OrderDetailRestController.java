package com.example.be.controller;

import com.example.be.dto.IOrderDetailDto;
import com.example.be.model.Account;
import com.example.be.model.OrderDetail;
import com.example.be.model.Orders;
import com.example.be.model.Product;
import com.example.be.service.IOrderDetailService;
import com.example.be.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/order-detail")
public class OrderDetailRestController {

    @Autowired
    private IOrderDetailService orderDetailService;

    @Autowired
    private IOrdersService ordersService;


    @GetMapping("")
    public ResponseEntity<Page<IOrderDetailDto>> getAllAndSearchDocument(
            @RequestParam Long id,
            @PageableDefault(value = 40) Pageable pageable
    ) {
        Page<IOrderDetailDto> orderDetailDto = orderDetailService.findAllDetailDto(id, pageable);
        if (orderDetailDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(orderDetailDto, HttpStatus.OK);
    }

    @PatchMapping("/increase-amount")
    public ResponseEntity<HttpStatus> increaseAmount(@RequestParam Long id) {
        orderDetailService.increaseQuantity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/decrease-amount")
    public ResponseEntity<HttpStatus> decreaseAmount(@RequestParam Long id) {
        orderDetailService.decreaseQuantity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<OrderDetail> deleteOrderDetail(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        orderDetailService.removeOrderDetail(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/addCart")
    public ResponseEntity<?> addToCart(@RequestParam Long accountId, @RequestParam Long productId, @RequestParam Integer amount) {
        List<IOrderDetailDto> orderDetails = orderDetailService.findAllListDetailDto(accountId);
        int count = 0;
        OrderDetail orderDetailA = null;
        for (IOrderDetailDto orderDetailDto : orderDetails) {
            if (orderDetailDto.getProductId().equals(productId)) {
                orderDetailA = this.orderDetailService.findByIdOrderDetail(orderDetailDto.getOrderDerailId());
                orderDetailA.setAmount(orderDetailA.getAmount() + amount);
                count++;
            }
        }
        if (count == 1) {
            this.orderDetailService.saveOrderDetail(orderDetailA);
            return new ResponseEntity<>(HttpStatus.OK);
        } else if (count == 0) {
            Orders orders = new Orders();
            orders.setAccount(new Account(accountId));
            orders.setQuantity(1);
            orders.setOrderDate(new Date());
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProduct(new Product(productId));
            orderDetail.setAmount(1);
            orderDetail.setOrderProductTime(LocalDateTime.now());
            orderDetail.setFlagDelete(false);
            orderDetail.setFlagBuy(false);
            ordersService.saveOrders(orders);
            orderDetail.setOrders(orders);
            orderDetailService.saveOrderDetail(orderDetail);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/update-buy-success")
    public ResponseEntity<HttpStatus> updateBuySuccess(@RequestParam Long accountId) {
        orderDetailService.updateBuySuccess(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/purchase-history")
    public ResponseEntity<Page<IOrderDetailDto>> getAllPurchaseHistory(
            @RequestParam Long id,
            @PageableDefault(value = 70) Pageable pageable
    ) {
        Page<IOrderDetailDto> orderDetailDto = orderDetailService.findAllPurchaseHistory(id, pageable);
        if (orderDetailDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(orderDetailDto, HttpStatus.OK);
    }

    @GetMapping("/total/{id}")
    public ResponseEntity<IOrderDetailDto> getTotalByIdOrder(@PathVariable("id") Long id) {
        IOrderDetailDto orderDetailDto = orderDetailService.getTotal(id);
        return new ResponseEntity<>(orderDetailDto, HttpStatus.OK);
    }

    @GetMapping("/amount-shopping-cart/{id}")
    public ResponseEntity<List<IOrderDetailDto>> showList(@PathVariable("id") Long id){
        List<IOrderDetailDto> orderDetailDto = orderDetailService.amountShoppingCart(id);
        return new ResponseEntity<>(orderDetailDto, HttpStatus.OK);
    }

}
