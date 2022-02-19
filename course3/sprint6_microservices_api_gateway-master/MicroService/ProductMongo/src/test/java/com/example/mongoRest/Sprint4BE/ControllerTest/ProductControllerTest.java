//package com.example.mongoRest.Sprint4BE.ControllerTest;
//import com.example.mongoRest.Sprint4BE.ServiceTest.ProductService;
//import com.example.mongoRest.Sprint4BE.controller.ProductController;
//import com.example.mongoRest.Sprint4BE.exception.ProductAlreadyExistException;
//import com.example.mongoRest.Sprint4BE.model.Product;
//import com.example.mongoRest.Sprint4BE.model.ProductDesc;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.Arrays;
//import java.util.List;
//import static org.mockito.Mockito.*;
//import static org.mockito.internal.verification.VerificationModeFactory.times;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//@ExtendWith(MockitoExtension.class)
//
//public class ProductControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private ProductService productService;
//    private Product product1, product2;
//    private ProductDesc productDesc1, productDesc2;
//    List<Product> productList;
//
//    @InjectMocks
//    private ProductController productController;
//
//    @BeforeEach
//    public void setUp(){
//        product1 = new Product(12, "Z Fold", productDesc1, 54000);
//        product2 = new Product(7, "IPhone SE 2021", productDesc2, 45000);
//        productDesc1 = new ProductDesc(10,"Samsung");
//        productDesc2 = new ProductDesc(7,"Apple");
//        productList = Arrays.asList(product1, product2);
//        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
//    }
//
//    @AfterEach
//    public void tearDown(){
//        product1 = null;
//        product2 = null;
//    }
//
//    @Test
//    public void givenProductToSaveReturnSaveProductSuccess() throws Exception {
//        when(productService.saveProduct(any())).thenReturn(product1);
//        mockMvc.perform(post("/api/prod/product")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonToString(product1)))
//                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
//        verify(productService,times(1)).saveProduct(any());
//    }
//
//    @Test
//    public void givenProductToSaveReturnSaveProductFailure() throws Exception {
//        when(productService.saveProduct(any())).thenThrow(ProductAlreadyExistException.class);
//        mockMvc.perform(post("/api/prod/product")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonToString(product1)))
//                .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());
//        verify(productService,times(1)).saveProduct(any());
//
//    }
//
//    @Test
//    public void givenCustomerCodeDeleteCustomer() throws Exception {
//        when(productService.deleteByProductId(anyInt())).thenReturn(true);
//        mockMvc.perform(delete("/api/prod/delete/12")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//        verify(productService,times(1)).deleteByProductId(anyInt());
//
//    }
//
//    private static String jsonToString(final Object ob) throws JsonProcessingException {
//        String result;
//
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            String jsonContent = mapper.writeValueAsString(ob);
//            result = jsonContent;
//        } catch(JsonProcessingException e) {
//            result = "JSON processing error";
//        }
//
//        return result;
//    }
//}
