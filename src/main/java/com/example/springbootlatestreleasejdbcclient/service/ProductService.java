package com.example.springbootlatestreleasejdbcclient.service;

import com.example.springbootlatestreleasejdbcclient.enitity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    void addProduct(Product product);

    void updateProduct(Integer id ,Product product);

    void deleteProduct(Integer id);
}
