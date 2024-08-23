package com.oracle.team1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.team1.entity.Product;
import com.oracle.team1.exceptions.ResourceNotFoundException;
import com.oracle.team1.repositories.ProductRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
    private ProductRepository ProductRepository;

    @GetMapping("/Products")
    public List < Product > getAllProducts() {
        return ProductRepository.findAll();
    }

    @GetMapping("/Products/{id}") //server endpoints (put request for updating)
    public ResponseEntity < Product > getProductById(@PathVariable(value = "id") Integer ProductId)
    throws ResourceNotFoundException {
        Product Product = ProductRepository.findById(ProductId)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + ProductId));
        return ResponseEntity.ok().body(Product);
    }
}
