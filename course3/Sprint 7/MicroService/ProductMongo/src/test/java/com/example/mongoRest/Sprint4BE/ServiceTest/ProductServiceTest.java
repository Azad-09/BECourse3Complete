//package com.example.mongoRest.Sprint4BE.ServiceTest;
//
//import com.example.mongoRest.Sprint4BE.exception.ProductAlreadyExistException;
//import com.example.mongoRest.Sprint4BE.exception.ProductNotFoundException;
//import com.example.mongoRest.Sprint4BE.model.Product;
//import com.example.mongoRest.Sprint4BE.model.ProductDesc;
//import com.example.mongoRest.Sprint4BE.repo.ProductRepo;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class ProductServiceTest {
//
//    @Mock
//    private ProductRepo productRepo;
//
//    @InjectMocks
//    private ProductService productService;
//    private Product product1, product2;
//    List<Product> productList;
//    ProductDesc productDesc1,productDesc2;
//
//    @BeforeEach
//    public void setUp(){
//        product1 = new Product(9, "Note 6", productDesc1, 12000);
//        productDesc1 = new ProductDesc(3, "MI");
//        product2 = new Product(8, "Moto Z", productDesc2, 16000);
//        productDesc2 = new ProductDesc(9, "Motorola");
//        productList = Arrays.asList(product1, product2);
//    }
//
//    @AfterEach
//    public void tearDown(){
//        product1 = null;
//        product2 = null;
//
//    }
//    //Saving And Returning Success Message
//    @Test
//    public void givenProductToSaveReturnSavedProductSuccess() throws ProductAlreadyExistException {
//        when(productRepo.findById(product1.getProductID())).thenReturn(Optional.ofNullable(null));
//        when(productRepo.save(any())).thenReturn(product1);
//        assertEquals(product1,productService.saveProduct(product1));
//        verify(productRepo,times(1)).save(any());
//        verify(productRepo,times(1)).findById(any());
//
//    }
//
//    //Not Saving And throwing Product already Exist using the Exception Class
//   @Test
//    public void givenProductToSaveReturnProductFailure(){
//       when(productRepo.findById(product1.getProductID())).thenReturn(Optional.ofNullable(product1));
//       assertThrows(ProductAlreadyExistException.class,()->productService.saveProduct(product1));
//       verify(productRepo,times(0)).save(any());
//       verify(productRepo,times(1)).findById(any());
//   }
//
//   @Test
//    public void givenProductToDeleteShouldDeleteSuccess() throws ProductNotFoundException {
//       when(productRepo.findById(product1.getProductID())).thenReturn(Optional.ofNullable(product1));
//       boolean flag = productService.deleteByProductId(product1.getProductID());
//       assertEquals(true,flag);
//
//       verify(productRepo,times(1)).deleteById(any());
//       verify(productRepo,times(1)).findById(any());
//   }
//
//
//
//
//}
