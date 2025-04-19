package com.jspider.productCrud.services;

import com.jspider.productCrud.dao.request.ProductRequestDao;
import com.jspider.productCrud.dao.response.ProductResponseDao;
import com.jspider.productCrud.entity.Product;
import com.jspider.productCrud.repository.ProductRepository;
import com.jspider.productCrud.repository.ProductRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImpl() {
        this.productRepository = new ProductRepositoryImpl();
    }


    @Override
    public void insertProduct(ProductRequestDao productRequestDto) {
            Product product = Product.requestDaoToProduct(productRequestDto);
            productRepository.insertProduct(product);
    }

    // Getting All Product
    @Override
    public List<ProductResponseDao> getAllProduct() {
        List<Product> products = productRepository.getAll();
        List<ProductResponseDao> responses = new ArrayList<>();
        for (Product product:products){
            responses.add(Product.productToResponseDao(product));
        }
        return responses;
    }

    // Getting Product By Id
    @Override
    public ProductResponseDao getProductById(int id) {
       return Product.productToResponseDao(productRepository.getById(id));

    }

    // Delete record by Id
    @Override
    public boolean removeProduct(int id) {
        int rowChanges = productRepository.deleteById(id);
        return rowChanges > 0;
    }

    @Override
    public boolean updateProductDetail(ProductRequestDao productRequest, int id) {
        return productRepository
                .updateProduct(Product.requestDaoToProduct(productRequest),id) >0;
    }

    @Override
    public void insertListOfProduct(List<ProductRequestDao> productRequests) {
        List<Product> products = new ArrayList<>();
        for (ProductRequestDao productRequest : productRequests){
            products.add(Product.requestDaoToProduct(productRequest));
        }
        int rows = productRepository.addAll(products);
        System.out.println(rows +" inserted");
    }

}


