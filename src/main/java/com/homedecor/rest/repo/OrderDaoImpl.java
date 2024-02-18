package com.homedecor.rest.repo;

import com.homedecor.rest.dto.*;
import com.homedecor.rest.entity.Order;
import com.homedecor.rest.entity.OrderItem;
import com.homedecor.rest.entity.ProductMaster;
import com.homedecor.rest.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    OrderRepository orderRepository;

    public List<OrderDTO> getOrdersByUser(Long userId) {
        List<Order> orders = orderRepository.findByUserId_UserId(userId);
        List<OrderDTO> orderDTOs = new ArrayList<>();

        for (Order order : orders) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrderId(order.getOrderId());
            orderDTO.setOrderDate(order.getOrderDate());
            orderDTO.setTotalPrice(order.getTotalPrice());
            orderDTO.setPaymentRef(order.getPaymentRef());
            orderDTO.setAddress(order.getAddress());
            List<OrderItemDTO> orderItemDTOs = new ArrayList<>();
            for (OrderItem orderItem : order.getOrderItems()) {
                OrderItemDTO orderItemDTO = new OrderItemDTO();
                orderItemDTO.setProductId(orderItem.getOrderItemId());
                orderItemDTO.setQuantity(orderItem.getQuantity());
                orderItemDTO.setPrice(orderItem.getProductMaster().getPrice());
                ProductMaster productMaster = orderItem.getProductMaster();
                orderItemDTO.setProduct(copyEntityToDto(productMaster));
                orderItemDTOs.add(orderItemDTO);

            }
            orderDTO.setOrderItems(orderItemDTOs);

            orderDTOs.add(orderDTO);
        }

        return orderDTOs;
    }

    public OrderDTO addOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setOrderDate(orderDTO.getOrderDate());
        order.setTotalPrice(orderDTO.getTotalPrice());
        order.setPaymentRef(orderDTO.getPaymentRef());
        order.setAddress(orderDTO.getAddress());
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemDTO orderItemDTO : orderDTO.getOrderItems()) {
            OrderItem orderItem = new OrderItem();
            ProductMaster productMaster = new ProductMaster();
            productMaster.setProductId(orderItemDTO.getProductId());
            orderItem.setProductMaster(productMaster);
            orderItem.setQuantity(orderItemDTO.getQuantity());
            orderItem.setOrder(order);
            orderItems.add(orderItem);
        }
        order.setOrderItems(new HashSet<>(orderItems));

        order.setStatus(orderDTO.getStatus()); // Set order status
        User user = new User();
        user.setUserId(orderDTO.getUserId());
        order.setUserId(user);
        order = orderRepository.save(order); // Save the order to the database

        OrderDTO addedOrderDTO = new OrderDTO();
        addedOrderDTO.setOrderId(order.getOrderId());
        addedOrderDTO.setOrderDate(order.getOrderDate());
        addedOrderDTO.setTotalPrice(order.getTotalPrice());
        addedOrderDTO.setPaymentRef(order.getPaymentRef());
        addedOrderDTO.setAddress(order.getAddress());
        addedOrderDTO.setOrderItems(orderDTO.getOrderItems());
        addedOrderDTO.setStatus(order.getStatus());

        return addedOrderDTO;
    }

    public OrderDTO updateOrder(Long orderId, OrderDTO orderDTO) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);

        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setOrderDate(orderDTO.getOrderDate());
            order.setTotalPrice(orderDTO.getTotalPrice());
            order.setPaymentRef(orderDTO.getPaymentRef());
            order.setAddress(orderDTO.getAddress());
            List<OrderItem> orderItems = new ArrayList<>();
            for (OrderItemDTO orderItemDTO : orderDTO.getOrderItems()) {
                OrderItem orderItem = new OrderItem();
                ProductMaster productMaster = new ProductMaster();
                productMaster.setProductId(orderItemDTO.getProductId());
                orderItem.setProductMaster(productMaster);
                orderItem.setQuantity(orderItemDTO.getQuantity());
                orderItem.setOrder(order);
                orderItems.add(orderItem);
            }

            order.setOrderItems(new HashSet<>(orderItems));

            order.setStatus(orderDTO.getStatus());
            User user = new User();
            user.setUserId(orderDTO.getUserId());
            order.setUserId(user);
            order = orderRepository.save(order); // Save the updated order to the database

            OrderDTO updatedOrderDTO = new OrderDTO();
            updatedOrderDTO.setOrderId(order.getOrderId());
            updatedOrderDTO.setOrderDate(order.getOrderDate());
            updatedOrderDTO.setTotalPrice(order.getTotalPrice());
            updatedOrderDTO.setPaymentRef(order.getPaymentRef());
            updatedOrderDTO.setAddress(order.getAddress());
            updatedOrderDTO.setOrderItems(orderDTO.getOrderItems());
            updatedOrderDTO.setStatus(order.getStatus());

            return updatedOrderDTO;
        } else {
            // Handle case when order is not found
            return null;
        }
    }
    private ProductMasterDto copyEntityToDto(ProductMaster productMaster) {
        ProductMasterDto ProductMasterDto = new ProductMasterDto();
        BeanUtils.copyProperties(productMaster, ProductMasterDto);

        if (productMaster.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setCategoryId(productMaster.getCategory().getCategoryId());
            categoryDto.setCategoryName(productMaster.getCategory().getCategoryName());
            ProductMasterDto.setCategoryDto(categoryDto);
        }
        if (productMaster.getBrand() != null) {
            BrandDto brandDto = new BrandDto();
            brandDto.setBrandId(productMaster.getBrand().getBrandId());
            brandDto.setBrandName(productMaster.getBrand().getBrandName());
            ProductMasterDto.setBrandDto(brandDto);
        }
        if (productMaster.getUserId() != null) {
            UserDto userDto = new UserDto();
            userDto.setUserId(productMaster.getUserId().getUserId());
            userDto.setUserName(productMaster.getUserId().getUserName());
            ProductMasterDto.setUserId(userDto);
        }


        return ProductMasterDto;
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
