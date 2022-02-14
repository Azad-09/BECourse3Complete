//package com.example.mongoRest.Sprint4BE.RepoTest;
//
//import com.example.mongoRest.Sprint4BE.model.Product;
//import com.example.mongoRest.Sprint4BE.model.ProductDesc;
//import com.example.mongoRest.Sprint4BE.repo.ProductRepo;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class ProductRepoTest {
//
//    @Autowired
//    private ProductRepo productRepo;
//    private Product product;
//    private ProductDesc productDesc;
//
//    @BeforeEach
//    public void setUp(){
//        product = new Product(11,"Z Fold", productDesc, 54000 );
//        productDesc = new ProductDesc(10, "Samsung");
//    }
//
//    @AfterEach
//    public void tearDown(){
//        product = null;
//        productDesc = null;
//        productRepo.deleteAll();
//    }
//
//    @Test
//    public void givenProductToSaveShouldReturnProduct() {
//
//        productRepo.insert(product);
//        Product product1 = productRepo.findById(product.getProductID()).get();
//        assertNotNull(product1);
//        assertEquals(product.getProductID(), product1.getProductID());
//
//    }
//
//    @Test
//    public void givenProductToDeleteShouldDeleteProduct(){
//        productRepo.insert(product);
//        Product product1 = productRepo.findById(product.getProductID()).get();
//        productRepo.delete(product1);
//        assertEquals(Optional.empty(),productRepo.findById(product.getProductID()));
//    }
//
//    @Test
//    public void givenTrackReturnGetAllTrack(){
//        productRepo.insert(product);
//
//        ProductDesc productDesc1 = new ProductDesc(7, "Apple");
//        Product product1 = new Product(7,"IPhone SE 2021", productDesc1, 45000 );
//        productRepo.insert(product1);
//        List<Product> list = productRepo.findAll();
//        assertEquals(2,list.size());
//        assertEquals("IPhone SE 2021", list.get(1).getProductName());
//        assertEquals(45000, list.get(1).getPrice());
//
//    }
//
//
//}
