package com.homedecor.rest.service;

import com.homedecor.rest.dto.OrderDTO;
import com.homedecor.rest.dto.RoleDto;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getOrdersByUser(Long userId);

    OrderDTO addOrder(OrderDTO orderDTO);

    OrderDTO updateOrder(Long orderId, OrderDTO orderDTO);

    void deleteOrder(Long orderId);
}
