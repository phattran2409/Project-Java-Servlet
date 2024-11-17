/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Product;

/**
 *
 * @author ADMIN
 */
public class Product {
    private String ProductID; 
    private String ProductName; 
    private String image;
    private String Brand;
    private int quantity;
    private Double Price;
    private Double discount; 
    private int Show;

    public Product() {
    }

    public Product(String ProductID, String ProductName, String image, String Brand, int quantity, Double Price, Double discount, int Show) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.image = image;
        this.Brand = Brand;
        this.quantity = quantity;
        this.Price = Price;
        this.discount = discount;
        this.Show = Show;
    }
    public Double getNewPrice() {
        return Price * ( 1 - discount) ; 
    }
    public String getProductID() {
        return ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getImage() {
        return image;
    }

    public String getBrand() {
        return Brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return Price;
    }

    public Double getDiscount() {
        return discount;
    }

    public int getShow() {
        return Show;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double Price) {
        this.Price = Price;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public void setShow(int Show) {
        this.Show = Show;
    }
    
    
    
           
  
}
