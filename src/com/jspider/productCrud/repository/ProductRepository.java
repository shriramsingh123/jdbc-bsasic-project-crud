package com.jspider.productCrud.repository;

import com.jspider.productCrud.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAll();
    void insertProduct(Product product);
    int updateProduct(Product product,int id);
    int deleteById(int id);

    Product getById(int id);

    int addAll(List<Product> products);
}
