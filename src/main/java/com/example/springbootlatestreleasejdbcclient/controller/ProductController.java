package com.example.springbootlatestreleasejdbcclient.controller;

import com.example.springbootlatestreleasejdbcclient.enitity.Product;
import com.example.springbootlatestreleasejdbcclient.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    List<Product> fetchAllProducts(){
       return productService.getAllProducts();
    }
    @PostMapping("/insert")
    void insertProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @PutMapping("/update/{id}")
    void updateProduct(@PathVariable Integer id ,@RequestBody Product product){
        productService.updateProduct(id ,product);
    }

    @DeleteMapping("/delete/{id}")
    void deleteProduct(@PathVariable Integer id ){
        productService.deleteProduct(id);
    }
}
