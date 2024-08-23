package com.oracle.team1.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.team1.entity.Product;
import com.oracle.team1.exceptions.ResourceNotFoundException;
import com.oracle.team1.repositories.ProductRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List < Product > getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}") //server endpoints (put request for updating)
    public ResponseEntity < Product > getProductById(@PathVariable(value = "id") Integer ProductId)
    throws ResourceNotFoundException {
        Product product = productRepository.findById(ProductId)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + ProductId));
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/products") 
    public Product createProduct(@RequestBody Product product) { //valid was removed
        return productRepository.save(product);
    }

    @PutMapping("/products/{id}") //for updating the Products
    //valid was removed.
    public ResponseEntity < Product > updateProduct(Integer productId, @RequestBody Product productDetails) throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

        product.setPrice(productDetails.getPrice());
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        final Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/Products/{id}")
    public Map < String, Boolean > deleteProduct(@PathVariable(value = "id") Integer productId)
    throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

        productRepository.delete(product);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
