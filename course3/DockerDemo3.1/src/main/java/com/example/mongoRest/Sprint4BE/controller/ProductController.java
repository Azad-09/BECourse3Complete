package com.example.mongoRest.Sprint4BE.controller;

import com.example.mongoRest.Sprint4BE.exception.ProductAlreadyExistException;
import com.example.mongoRest.Sprint4BE.exception.ProductNotFoundException;
import com.example.mongoRest.Sprint4BE.model.Product;
import com.example.mongoRest.Sprint4BE.service.ProductService;
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
        try {
            productService.saveProduct(product);
            responseEntity = new ResponseEntity(product , HttpStatus.CREATED);
        } catch (ProductAlreadyExistException e) {
            throw new ProductAlreadyExistException();
        }
        catch (Exception e)
        {
            responseEntity = new ResponseEntity<>("Error  !!!Try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    @GetMapping("/prodetail")
    public ResponseEntity<?> getAllProduct(){
       try{
           responseEntity = new ResponseEntity(productService.getAllProduct(), HttpStatus.OK);
       }catch (Exception e){
           responseEntity = new ResponseEntity("Error Found", HttpStatus.INTERNAL_SERVER_ERROR);
       }
       return responseEntity;
    }

    @GetMapping("/prodbrand/{brand}")
    public ResponseEntity<?> getAllProductByBrand(@PathVariable String brand){
        try{
            responseEntity = new ResponseEntity(productService.getAllProductByBrand(brand), HttpStatus.OK);
        }catch(Exception e){
            responseEntity = new ResponseEntity("Error!! from the server Side", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteByProductId(@PathVariable int id) throws ProductNotFoundException {
        try{
            productService.deleteByProductId(id);
            responseEntity = new ResponseEntity("Successfully Deleted", HttpStatus.OK);
        }catch (ProductNotFoundException e ){
                throw new ProductNotFoundException();
        } catch (Exception e) {
            String ex = e.getMessage();
            System.out.println(ex);
            responseEntity = new ResponseEntity("Error !! Try After Sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
