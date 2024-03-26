package com.abler.recyclerview;

public class Product {

    private String title, description, brand, category;
    private int price;
    private Double discountPercentage;
    private Double rating;
    private Double stock;




    public Product(String title, int price, Double discountPercentage, Double rating, String description, String brand, String category){
        this.title = title;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.rating = rating;
        this.description = description;
        this.brand = brand;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public String getBrand() {
        return brand;
    }

    public Double getStock() {
        return stock;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public Double getRating() {
        return rating;
    }

}

