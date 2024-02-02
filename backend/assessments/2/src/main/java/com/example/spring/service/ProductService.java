package com.example.spring.service;


import com.example.spring.dao.ProductDAO;
import com.example.spring.exception.custom.ResourceNotFound;
import com.example.spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;
    public Product createProduct(Product product){
        return productDAO.save(product);
    }

    public List<Product> getProductDetails(Product product){
        return productDAO.findAll();
    }
    public void deleteProduct(int id){
        productDAO.deleteById(id);
    }
    public Product updateProduct(int id, int quantity){
       return productDAO.updateProduct(quantity,id);
    }
    public Product getProductbyId(int id) throws ResourceNotFound {
        Product product=new Product();
        try {
            productDAO.getProductById(id);
        }catch (Exception e){
            throw new ResourceNotFound("couldnt find user to delete");
        }
        return product;
    }
}
