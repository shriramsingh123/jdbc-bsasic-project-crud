package com.jspider.productCrud.entity;

import com.jspider.productCrud.dao.request.ProductRequestDao;
import com.jspider.productCrud.dao.response.ProductResponseDao;

import java.util.Date;


public class Product {

    private int id;
    private String name;
    private String color;
    private double price;
    private Date manufacturingDate;

    public Product() {
    }

    public Product(int id, String name, String color, double price, Date manufacturingDate) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.manufacturingDate = manufacturingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public java.sql.Date getManufacturingDate() {
        return (java.sql.Date) manufacturingDate;
    }

    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public static Product requestDaoToProduct(ProductRequestDao productRequestDao){
        Product product = new Product();
            product.setId(productRequestDao.getId());
            product.setName(productRequestDao.getName());
            product.setColor(productRequestDao.getColor());
            product.setPrice(productRequestDao.getPrice());
            Date date = new Date();
            date = new java.sql.Date(date.getTime());
            product.setManufacturingDate(date);
        return product;
    }

    public static ProductResponseDao productToResponseDao(Product product){
        ProductResponseDao responseDao = new ProductResponseDao();
        responseDao.setId(product.getId());
        responseDao.setName(product.getName());
        responseDao.setColor(product.getColor());
        responseDao.setPrice(product.getPrice());
        responseDao.setManufacturingDate(product.getManufacturingDate());
        return responseDao;
    }


}
