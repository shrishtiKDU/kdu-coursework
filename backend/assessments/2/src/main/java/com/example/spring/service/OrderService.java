package com.example.spring.service;

import com.example.spring.dao.*;
import com.example.spring.exception.custom.ResourceNotFound;
import com.example.spring.model.Cart;
import com.example.spring.model.Order;
import com.example.spring.model.Person;
import com.example.spring.model.User;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class OrderService {


    @Autowired
    UserDAO userDAO;
    @Autowired
    OrderDAO orderDAO;
    @Autowired
    CartDAO cartDAO;


    public void checkoutOrder(int userId, int cartId) throws ResourceNotFound {

        Cart cart = cartDAO.getCartById(cartId);
        User user=userDAO.getUserById(userId);
        if(cart==null || user==null){
            throw  new ResourceNotFound("Cart not created");
        }
        Order order= new Order();
        order.setCart(cart);
        order.setAmount((int) Math.random());
        orderDAO.save(order);
    }


}
