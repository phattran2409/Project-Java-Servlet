/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Customer;

/**
 *
 * @author ADMIN
 */
public class CartDTO {
    private String P_ID; 
    private String productName;
    private int quantity; 
    private String image;
    private double price;
    private double discount;
    
    public CartDTO() {
    }

    public CartDTO(String P_ID, String productName, int quantity, String image, double discount) {
        this.P_ID = P_ID;
        this.productName = productName;
        this.quantity = quantity;
        this.image = image;
        this.discount = discount;
    }


  

    public String getP_ID() {
        return P_ID;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getDiscount() {
        return discount;
    }
    
    

    public void setP_ID(String P_ID) {
        this.P_ID = P_ID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
    
    
    
    
    
}
