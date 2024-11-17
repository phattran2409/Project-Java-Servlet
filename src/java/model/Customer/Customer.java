/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Customer;

/**
 *
 * @author ADMIN
 */
public class Customer {
    private String ID;
    private String FirstName;
    private String LastName;
    private String Password;

    public Customer() {
    }
    
    
    public Customer(String ID, String FirstName, String LastName, String Password) {
        this.ID = ID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Password = Password;
    }

    public String getID() {
        return ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getPassword() {
        return Password;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
    
}
