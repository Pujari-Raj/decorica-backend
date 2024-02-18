package com.homedecor.rest.repo;

import com.homedecor.rest.dto.OrderDTO;
import com.homedecor.rest.dto.OrderItemDTO;
import com.homedecor.rest.entity.Order;
import com.homedecor.rest.entity.OrderItem;
import com.homedecor.rest.entity.ProductMaster;

import java.util.ArrayList;
import java.util.List;

public interface OrderDao {
    public List<OrderDTO> getOrdersByUser(Long userId) ;

    public OrderDTO addOrder(OrderDTO orderDTO) ;

    public OrderDTO updateOrder(Long orderId, OrderDTO orderDTO) ;

    public void deleteOrder(Long orderId) ;
}
