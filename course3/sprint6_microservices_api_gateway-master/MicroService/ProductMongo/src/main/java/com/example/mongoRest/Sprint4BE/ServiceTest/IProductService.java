package com.example.mongoRest.Sprint4BE.ServiceTest;


import com.example.mongoRest.Sprint4BE.exception.ProductAlreadyExistException;
import com.example.mongoRest.Sprint4BE.exception.ProductNotFoundException;
import com.example.mongoRest.Sprint4BE.model.Product;

import java.util.List;

public interface IProductService {
    Product saveProduct(Product product) throws ProductAlreadyExistException;
    List<Product> getAllProduct();
    List<Product>  getAllProductByBrand(String brand) throws ProductNotFoundException;
    boolean deleteByProductId(int productId) throws ProductNotFoundException;
}
