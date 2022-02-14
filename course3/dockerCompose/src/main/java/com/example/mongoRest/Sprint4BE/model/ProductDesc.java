package com.example.mongoRest.Sprint4BE.model;

public class ProductDesc {
    private int stock;
    private String brand;

    public ProductDesc(int stock, String brand) {
        this.stock = stock;
        this.brand = brand;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "ProductDesc{" +
                "stock=" + stock +
                ", brand='" + brand + '\'' +
                '}';
    }
}
