package com.jspider.productCrud.controller;

import com.jspider.productCrud.dao.request.ProductRequestDao;
import com.jspider.productCrud.dao.response.ProductResponseDao;
import com.jspider.productCrud.services.ProductService;
import com.jspider.productCrud.services.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ProductController {

    public static void main(String[] args) {
        ProductService service = new ProductServiceImpl();


        // Insert the product
//        ProductRequestDao product1 = new ProductRequestDao();
//        product1.setId(2348);
//        product1.setName("Paint");
//        product1.setColor("White-Black");
//        product1.setPrice(70.20);
//        service.insertProduct(product1);
//
        // Insert a list of product
//        List<ProductRequestDao> productRequests = new ArrayList<>();
//        ProductRequestDao product1 = new ProductRequestDao(2353,"Hoover","Black",237.56);
//        ProductRequestDao product2 = new ProductRequestDao(2349,"SelloTape","Pink",233.50);
//        ProductRequestDao product3 = new ProductRequestDao(2350,"Jacuzzi","Blue",233.40);
//        ProductRequestDao product4 = new ProductRequestDao(2351,"Nike","White",120.5);
//        ProductRequestDao product5 = new ProductRequestDao(2352,"Cola","Red-Black",226.45);

//        productRequests.add(product1);
//        productRequests.add(product2);
//        productRequests.add(product3);
//        productRequests.add(product4);
//        productRequests.add(product5);
//        service.insertListOfProduct(productRequests);

//         Fetch List of product
//        List<ProductResponseDao> allProduct2 = service.getAllProduct();
//        System.out.println(allProduct2);

        // Fetch Product By Id
        ProductResponseDao productById = service.getProductById(2349);
        System.out.println(productById);


//         Remove Product By Id
//        System.out.println(service.removeProduct(2348));



        // Update Whole Record By Id
//        ProductRequestDao productRequest = new ProductRequestDao("T-Shirt","Pink",200.50);
//        int id = 2347;
//        System.out.println( service.updateProductDetail(productRequest,id));






        System.out.println("Terminated Successfully");
    }

}
