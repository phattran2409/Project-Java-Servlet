/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product.Product;

/**
 *
 * @author ADMIN
 */
public class WishList {

    public WishList() {
    }
    
    public List<Product> loadWL(String C_ID){
        List<Product> list = new ArrayList<>();
         Connection conn =null; 
       PreparedStatement  pst = null; 
       ResultSet rs =null; 
       
        String querry = "SELECT P.P_ID , P.P_Name  ,P.image ,P.Brand ,P.Quantity ,P.Price , P.discount ,P.Show \n"
                + " FROM wishList wl JOIN Product P on wl.P_ID = P.P_ID\n"
                + " WHERE C_ID = 'AndyChen123'";
        
       try {
          conn  = Dbutils.DbConnect.getConnection();
          pst  = conn.prepareStatement(querry); 
          pst.setString(1, C_ID);
          rs = pst.executeQuery();
          while (rs.next()){
              list.add(new Product(rs.getString(1) , rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(5), rs.getDouble(6), rs.getDouble(7),rs.getInt(8)));
              
          }
           
       }catch (SQLException ex) {
           ex.printStackTrace();
       }
       return list;
        
    }
     
    public boolean Insert(String P_ID , String C_ID){
        boolean check =false;
        
        
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String querry = "  INSERT INTO wishList(C_ID , P_ID) VALUES(?,?);";
        
       try {
          conn  = Dbutils.DbConnect.getConnection();
          pst  = conn.prepareStatement(querry); 
          pst.setString(1, C_ID);
          pst.setString(2, P_ID);
           
       }catch (SQLException ex) {
           ex.printStackTrace();
       }
        return check;
        
    }
     
}
