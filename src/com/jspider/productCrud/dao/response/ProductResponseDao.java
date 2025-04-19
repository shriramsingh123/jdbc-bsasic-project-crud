package com.jspider.productCrud.dao.response;

import java.util.Date;

public class ProductResponseDao {

    private int id;
    private String name;
    private String color;
    private double price;
    private Date manufacturingDate;

    public ProductResponseDao() {
    }

    public ProductResponseDao(int id, String name, String color, double price, Date manufacturingDate) {
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

    public Date getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", manufacturingDate=" + manufacturingDate +
                '}';
    }
}
