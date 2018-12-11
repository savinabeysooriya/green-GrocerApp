package com.savin.greengrocerapp1.Model;

public class Food {

    private String Name;
    private String Image;
    private String Discount;
    private String MenuId;
    private String Price;

    public Food() {
    }

    public Food(String name, String image, String discount, String menuId ,String price) {
        Name = name;
        Image = image;
        Discount = discount;
        MenuId = menuId;
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public String getPrice(){
        return Price;
    }

    public void setPrice(String price){
        Price = price;
    }
}

