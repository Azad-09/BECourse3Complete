package com.example.mongoRest.Sprint4BE.controller;

import com.example.mongoRest.Sprint4BE.exception.ProductAlreadyExistException;
import com.example.mongoRest.Sprint4BE.exception.ProductNotFoundException;
import com.example.mongoRest.Sprint4BE.model.Product;
import com.example.mongoRest.Sprint4BE.ServiceTest.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prod")
public class ProductController {
    private ResponseEntity responseEntity;
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) throws ProductAlreadyExistException {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.OK);
    }

    @GetMapping("/prodetail")
    public ResponseEntity<?> getAllProduct(){
       return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/prodbrand/{brand}")
    public ResponseEntity<?> getAllProductByBrand(@PathVariable String brand) throws ProductNotFoundException{

        return new ResponseEntity<>(productService.getAllProductByBrand(brand), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteByProductId(@PathVariable int id) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.deleteByProductId(id), HttpStatus.OK);
    }
}
