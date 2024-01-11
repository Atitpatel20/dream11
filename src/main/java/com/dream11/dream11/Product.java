package com.dream11.dream11;

public class Product {
    private long id;
    private String productName;
    private String type;
    private double price;

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public Product(long id,String productName ,String type, double price) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.productName=productName;
    }



}
