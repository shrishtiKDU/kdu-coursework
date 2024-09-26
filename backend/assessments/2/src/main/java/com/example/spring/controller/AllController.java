package com.example.spring.controller;


import com.example.spring.dto.CartDTO;
import com.example.spring.dto.ProductDTO;
import com.example.spring.exception.custom.InvalidAuthException;
import com.example.spring.exception.custom.ResourceNotFound;
import com.example.spring.mapper.CartMapper;
import com.example.spring.mapper.ProductMapper;
import com.example.spring.model.Cart;
import com.example.spring.model.Order;
import com.example.spring.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class AllController {


    @Autowired
    UserAdditionService userAdditionService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;
    @Autowired
    InventoryService inventoryService;
    @Autowired
    CartService cartService;
    @Autowired
    AddressService addressService;


    @PostMapping("/addproduct")
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO){
     productService.createProduct(ProductMapper.mapToProduct(productDTO));
    String message= "product added";
    return ResponseEntity.ok(message);
    }

    @PutMapping("/update/product")
    public ResponseEntity<String> updateProduct(@RequestParam int quantity, @RequestParam int id){
        try {
            productService.updateProduct(id,quantity);
        }catch (InvalidAuthException e){
            throw new InvalidAuthException("couldnt update");
        }
        return ResponseEntity.ok("done");
    }

    @DeleteMapping("/delete/product")
    public ResponseEntity<String> deleteProduct(@RequestParam int id) throws ResourceNotFound {
       productService.deleteProduct(id);
       return ResponseEntity.ok("deleted");
    }

    // ******************* place order **************//

    @PostMapping("/orderitem")
    public ResponseEntity<String> addOrder(@RequestParam int userId, @RequestParam int cartId) throws ResourceNotFound{

        orderService.checkoutOrder(userId,cartId);
        return ResponseEntity.ok("order placed");

    }

    // ***************** add to cart ****************//

    @PostMapping("/addtocart")
    public ResponseEntity<String> addToCart(@RequestBody CartDTO cartDTO){
        cartService.saveCart(CartMapper.mapToCart(cartDTO));
        String message = " addedd to cart";
        return ResponseEntity.ok(message);
    }

    @GetMapping("/viewcart")
    public List<Cart> viewCart() {
        if(!cartService.getAllCarts().isEmpty()){
            return cartService.getAllCarts();
        }
        else {
            log.info("cart is null");
        }
      return null;
    }

}
