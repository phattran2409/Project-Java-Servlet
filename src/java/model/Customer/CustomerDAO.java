/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.ADMIN.Admin;

/**
 *
 * @author ADMIN
 */
public class CustomerDAO {

    public CustomerDAO() {
    }
    public Customer login(String ID , String Pass) {
        Customer  cus = null;
        Connection conn = null; 
        PreparedStatement pst = null; 
        ResultSet rs = null;
        String querry = "SELECT C.C_ID , C.C_FName , C.C_LName , C.Password\n"
                + "	FROM Customer C\n"
                + "	WHERE  C.C_ID  = ? AND C.Password = ?";
        conn = Dbutils.DbConnect.getConnection();
        try { 
        if(conn != null) {
            pst =conn.prepareStatement(querry);
            pst.setString(1, ID);
            pst.setString(2, Pass);
            rs = pst.executeQuery();
            if (rs.next()) {
                cus  = new Customer(rs.getString(1),rs.getString(2) ,rs.getString(3),rs.getString(4));
            }
        }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return cus;
    }
    public boolean insert(Customer User) {
       boolean check = false; 
       Connection conn  =null; 
       PreparedStatement  pst = null; 
      String Querry ="INSERT INTO Customer(C_ID,C_FName,C_LName,Password) VALUES  (?,?,?,?); ";
      conn = Dbutils.DbConnect.getConnection();
      try {
          pst = conn.prepareStatement(Querry);
          if (conn != null) {
              pst.setString(1, User.getID());
              pst.setString(2, User.getFirstName());
              pst.setString(3, User.getLastName());
              pst.setString(4, User.getPassword());
              check =pst.executeUpdate() > 0;
          }
      }catch(SQLException ex) {
          ex.printStackTrace();
      }
       return check;
    }
    
    public boolean Exist(String ID) {
     boolean  check = false;
       Connection conn  =null; 
       PreparedStatement  pst = null; 
       ResultSet rs = null;
        String Querry = "SELECT *\n"
                + "	FROM Customer \n"
                + "	WHERE  C_ID  = ?";
      conn = Dbutils.DbConnect.getConnection();
      try {
         pst = conn.prepareStatement(Querry);
          if (conn != null) {
              pst.setString(1, ID);
             rs = pst.executeQuery();
             check = rs.next();
          }
      }catch(SQLException ex) {
          ex.printStackTrace();
      }
       return check;
    }
    public static void main(String[] args) {
        CustomerDAO Dao = new CustomerDAO();
        boolean Exist = Dao.Exist("AndyChen123"); 
        System.out.println(Exist);
     
    }
}
