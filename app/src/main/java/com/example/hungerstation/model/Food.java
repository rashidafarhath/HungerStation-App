package com.example.hungerstation.model;

public class Food {
    private String name;
    private String price;
    private int image;
    private String category;

    private int quantity;

    public Food() {}
    public Food(String name, String price, int image, String category) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.category = category;
        this.quantity = 0;
    }

    public String getname(){return name;}
    public String getPrice(){return price;}
    public int getImage(){return image;}
    public String getCategory(){return category;}

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
