package com.abler.recyclerview;

public class Product {

    private String title;
    private int price;
    private Double discountPercentage, rating;

    public Product(String title, int price, Double discountPercentage, Double rating){
        this.title = title;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.rating = rating;
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

