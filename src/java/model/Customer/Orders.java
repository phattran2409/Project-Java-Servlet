/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Customer;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Orders {
    private String O_ID; 
    private String C_ID; 

    private float Total; 

    public Orders(String O_ID, String C_ID, float Total) {
        this.O_ID = O_ID;
        this.C_ID = C_ID;
        this.Total = Total;
    }



    public String getO_ID() {
        return O_ID;
    }

    public String getC_ID() {
        return C_ID;
    }

 
 

    public float getTotal() {
        return Total;
    }

    public void setO_ID(String O_ID) {
        this.O_ID = O_ID;
    }

    public void setC_ID(String C_ID) {
        this.C_ID = C_ID;
    }


    public void setTotal(float Total) {
        this.Total = Total;
    }
    
}


