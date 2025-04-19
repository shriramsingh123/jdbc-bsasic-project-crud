package com.jspider.productCrud.services;

import com.jspider.productCrud.dao.request.ProductRequestDao;
import com.jspider.productCrud.dao.response.ProductResponseDao;

import java.util.List;

public interface ProductService {

    void insertProduct(ProductRequestDao productRequest);
    List<ProductResponseDao> getAllProduct();

    ProductResponseDao getProductById(int id);

    boolean removeProduct(int id);

    boolean updateProductDetail(ProductRequestDao productRequest, int id);

    void insertListOfProduct(List<ProductRequestDao> productRequests);
}
