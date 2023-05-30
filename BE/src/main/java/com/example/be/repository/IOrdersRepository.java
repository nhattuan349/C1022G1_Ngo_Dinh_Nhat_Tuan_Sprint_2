package com.example.be.repository;

import com.example.be.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdersRepository extends JpaRepository<Orders,Long> {



}
