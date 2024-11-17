/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Customer;

/**
 *
 * @author ADMIN
 */
public class OdersDetails {
    private String O_ID;
    private String P_ID;
    private int quantity; 
    private double Price;

    public OdersDetails(String O_ID, String P_ID, int quantity, double Price) {
        this.O_ID = O_ID;
        this.P_ID = P_ID;
        this.quantity = quantity;
        this.Price = Price;
    }

    public String getO_ID() {
        return O_ID;
    }

    public String getP_ID() {
        return P_ID;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return Price;
    }

    

    public void setO_ID(String O_ID) {
        this.O_ID = O_ID;
    }

    public void setP_ID(String P_ID) {
        this.P_ID = P_ID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
     
   
}
