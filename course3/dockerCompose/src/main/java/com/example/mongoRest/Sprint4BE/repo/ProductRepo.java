package com.example.mongoRest.Sprint4BE.repo;

import com.example.mongoRest.Sprint4BE.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepo extends MongoRepository<Product,Integer> {

    @Query("{'description.brand' : {$in : [?0]}}")
    List<Product> findAllProductByBrand(String brand);

}
