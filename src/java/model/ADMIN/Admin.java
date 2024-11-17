/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.ADMIN;

/**
 *
 * @author ADMIN
 */
public class Admin {
    private String Ad_ID;
    private String Ad_Name; 
    private String Password;
    private int role;

    public Admin(String Ad_ID, String Ad_Name, String Password, int role) {
        this.Ad_ID = Ad_ID;
        this.Ad_Name = Ad_Name;
        this.Password = Password;
        this.role = role;
    }

    public String getAd_ID() {
        return Ad_ID;
    }

    public String getAd_Name() {
        return Ad_Name;
    }

    public String getPassword() {
        return Password;
    }

    public int getRole() {
        return role;
    }

    public void setAd_ID(String Ad_ID) {
        this.Ad_ID = Ad_ID;
    }

    public void setAd_Name(String Ad_Name) {
        this.Ad_Name = Ad_Name;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
}
