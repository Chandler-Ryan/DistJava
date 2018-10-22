package com.chandlerryan;

public class Product {
    private String Prodnum;
    private String Description;
    private double Price;

    public Product(String prodnum, String description, double price) {
        Prodnum = prodnum;
        Description = description;
        Price = price;
    }

    public String getProdnum() {
        return Prodnum;
    }

    public void setProdnum(String prodnum) {
        Prodnum = prodnum;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
