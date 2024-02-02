package com.example.spring.service;


import com.example.spring.dao.CartDAO;
import com.example.spring.dao.ProductDAO;
import com.example.spring.exception.custom.ResourceNotFound;
import com.example.spring.model.Cart;
import com.example.spring.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CartService {

    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private CartDAO cartDAO;
    public Cart saveCart(Cart cart){
        return cartDAO.save(cart);
    }

    public Cart getCartById(int id){
        return cartDAO.getCartById(id);
    }

    public Cart addProductToCart(int cartId,int productId, int quantity) throws ResourceNotFound {
        Product product =productDAO.findById(productId).orElseThrow(()-> new ResourceNotFound("no such item found"));
        if(product.getQuantity()<product.getThreshold()){
            log.info("OUT OF STOCK! need to restock");
        }
        Cart cart=cartDAO.getCartById(cartId);
         cart.getProducts().stream().toList().addLast(product);
        cartDAO.save(cart);

        return cart;
    }
    public List<Cart> getAllCarts(){
        return cartDAO.findAll();
    }

}
