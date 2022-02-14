package com.example.mongoRest.Sprint4BE.service;

import com.example.mongoRest.Sprint4BE.exception.ProductAlreadyExistException;
import com.example.mongoRest.Sprint4BE.exception.ProductNotFoundException;
import com.example.mongoRest.Sprint4BE.model.Product;
import com.example.mongoRest.Sprint4BE.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductService implements IProductService {
    private ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product saveProduct(Product product) throws ProductAlreadyExistException {
        if (productRepo.findById(product.getProductID()).isPresent()){
            throw new ProductAlreadyExistException();
        }
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> getAllProductByBrand(String brand) throws ProductNotFoundException {
        if (productRepo.findAllProductByBrand(brand).isEmpty()){
            throw new ProductNotFoundException();
        }
        return productRepo.findAllProductByBrand(brand);
    }

    @Override
    public boolean deleteByProductId(int productId) throws ProductNotFoundException {
        boolean flag = false;
        if(productRepo.findById(productId).isEmpty()){
            throw new ProductNotFoundException();
        }else{
            productRepo.deleteById(productId);
            flag = true;
        }
        return flag;
    }
}
