package com.nekos.cruddemo.repository;

import com.nekos.cruddemo.entity.Order;
import com.nekos.cruddemo.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

    @Query("SELECT o FROM OrderDetails o WHERE o.order = :order")
    List<OrderDetails> findByOrder(Order order);

}
