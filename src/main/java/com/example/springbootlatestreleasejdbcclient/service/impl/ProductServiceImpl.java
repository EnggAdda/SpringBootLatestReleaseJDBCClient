package com.example.springbootlatestreleasejdbcclient.service.impl;

import com.example.springbootlatestreleasejdbcclient.enitity.Product;
import com.example.springbootlatestreleasejdbcclient.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


     @Autowired
     private JdbcClient  jdbcClient ;


    @Override
    public List<Product> getAllProducts() {
        return jdbcClient.sql("select * from product")
                .query(Product.class)
                .list();
    }

    @Override
    public void addProduct(Product product) {
       jdbcClient.sql("insert into product (id, name,price,quantity) values(?,?,?,?)")
               .params(List.of(product.getId(), product.getName(), product.getPrice(), product.getQuantity())
               ).update();
    }

    @Override
    public void updateProduct(Integer id, Product product) {

         jdbcClient.sql("update product set name = ?, price = ?, quantity = ? where id = ?")
                 .params(List.of(product.getName(),product.getPrice(),product.getQuantity(),id))
                 .update();
    }

    @Override
    public void deleteProduct(Integer id) {
        jdbcClient.sql("DELETE FROM product WHERE id =?")
                .param( id)
                .update();
    }
}
