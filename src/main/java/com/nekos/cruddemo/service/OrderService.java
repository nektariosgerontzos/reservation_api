package com.nekos.cruddemo.service;

import com.nekos.cruddemo.dto.OrderDTO;
import com.nekos.cruddemo.entity.CafeTables;
import com.nekos.cruddemo.entity.Order;
import com.nekos.cruddemo.entity.OrderDetails;
import org.aspectj.weaver.ast.Or;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {

    List<Order> findAll();
    Order findById(int id);
    Order save(Order order);
    void deleteById(int id);
    Order update(int id, Order order);
    List<Order> findOrdersByTable(int id); // id defines the Table id
    List<OrderDetails> getOrderDetails(Integer orderId);
    BigDecimal calculateTotalPrice(Integer orderId);
    Order orderCompletion(int orderid);
    OrderDTO toDTO(Order order);
    List<OrderDTO> activeOrderByTable(int tableId);

}
