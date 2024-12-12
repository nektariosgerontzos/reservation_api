package com.nekos.cruddemo.repository;

import com.nekos.cruddemo.entity.CafeTables;
import com.nekos.cruddemo.entity.Order;
import com.nekos.cruddemo.entity.OrderDetails;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    //methods
    @Query("SELECT o FROM Order o WHERE o.cafeTable = :table")
    List<Order> findByTable(CafeTables table);




}
