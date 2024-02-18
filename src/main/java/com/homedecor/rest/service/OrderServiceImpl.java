package com.homedecor.rest.service;

import com.homedecor.rest.common.exceptions.RecordNotFoundException;
import com.homedecor.rest.common.messages.CustomMessage;
import com.homedecor.rest.dto.OrderDTO;
import com.homedecor.rest.dto.RoleDto;
import com.homedecor.rest.entity.Role;
import com.homedecor.rest.repo.OrderDao;
import com.homedecor.rest.repo.RoleDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;


    @Override
    public List<OrderDTO> getOrdersByUser(Long userId) {
        return orderDao.getOrdersByUser(userId);
    }

    @Override
    public OrderDTO addOrder(OrderDTO orderDTO) {
        return orderDao.addOrder(orderDTO);
    }

    @Override
    public OrderDTO updateOrder(Long orderId, OrderDTO orderDTO) {
        return orderDao.updateOrder(orderId,orderDTO);
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderDao.deleteOrder(orderId);
    }
}
