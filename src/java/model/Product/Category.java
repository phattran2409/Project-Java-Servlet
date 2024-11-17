/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Product;

/**
 *
 * @author ADMIN
 */
public class Category {
    private  String categoryID;
    private  String CateName; 

    public Category() {
    }

    public Category(String categoryID, String CateName) {
        this.categoryID = categoryID;
        this.CateName = CateName;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public String getCateName() {
        return CateName;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public void setCateName(String CateName) {
        this.CateName = CateName;
    }
    
    
    
}
