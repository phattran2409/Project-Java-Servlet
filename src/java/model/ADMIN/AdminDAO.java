/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.ADMIN;

import Dbutils.DbConnect;
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
public class AdminDAO {

    public AdminDAO() {
    }
    
    public Admin login(String AD_ID , String pass) { 
        Admin AD = null;
        Connection conn = null; 
        PreparedStatement pst = null; 
         ResultSet rs  = null; 
         
        conn = Dbutils.DbConnect.getConnection();
        String querry = "  SELECT AD_ID , AD_Name ,Password	 , RoleID\n"
                + "  FROM Admin \n"
                + "  WHERE AD_ID = ?   AND Password = ?";
        try {
           if (conn != null) {
              pst = conn.prepareStatement(querry);
              pst.setString(1, AD_ID);
              pst.setString(2, pass);
              rs =  pst.executeQuery();
            if (rs.next()) {
                 AD = new Admin(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
            
           }
        }catch(SQLException ex) {
        ex.printStackTrace();
        }
         return AD;
    }
    
    public List<Admin> loadStaff() {
       List<Admin> list = new ArrayList<>();
          Connection conn = null; 
        PreparedStatement pst = null; 
         ResultSet rs  = null; 
          conn = Dbutils.DbConnect.getConnection();
        String querry = "  SELECT *\n"
                + "  FROM  Admin \n"
                + "  WHERE RoleID != 0";
        try {
           if (conn != null) {
              pst = conn.prepareStatement(querry);
           
              rs =  pst.executeQuery();
            while (rs.next()) {
                list.add(new Admin(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
                
            }
            
           }
        }catch(SQLException ex) {
        ex.printStackTrace();
        }
       return list;
    }
    // ---> check duplicate 
    public boolean Exist(String id) {
        boolean check = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conn = Dbutils.DbConnect.getConnection();
        String Querry = "  Select *\n"
                + "  from Admin\n"
                + "  where AD_ID = ? ";
        try {
            if (conn != null) {
                pst = conn.prepareStatement(Querry);
                pst.setString(1, id);
                rs = pst.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check;
    }
  //  ----> Insert Staff 
    public boolean InsertStaff(Admin staff) {
        boolean check =false;
        Connection conn = null;
        PreparedStatement pst = null;
        conn = Dbutils.DbConnect.getConnection();
        String Querry = "INSERT INTO Admin(AD_ID,AD_Name,Password, RoleID) VALUES(? ,?,?,?);";
        try {
            if (conn != null) {
                pst = conn.prepareStatement(Querry);
                pst.setString(1, staff.getAd_ID());
                pst.setString(2, staff.getAd_Name());
                pst.setString(3, staff.getPassword());
                pst.setInt(4, staff.getRole());
                check =pst.executeUpdate() > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check;
    }
    // Search Staff 
     
    
    public List<Admin> SearchProductByAdmin(String key , String option){
           List<Admin> list = new ArrayList<>();
          Connection conn = null;
          PreparedStatement pst = null;
          ResultSet rs = null;
          String querry = "SELECT AD_ID,AD_Name,Password, RoleID FROM Admin   WHERE AD_Name LIKE ? ";
          String querry2 = "SELECT AD_ID,AD_Name,Password, RoleID FROM Admin   WHERE AD_ID LIKE ? ";
          conn  = DbConnect.getConnection();
          try {
          if (option.equals("Name")) { 
              if (conn != null) {
                  pst = conn.prepareStatement(querry);
                  pst.setString(1, "%"+key+"%");
                  rs = pst.executeQuery();
                  while(rs.next()) {
                    list.add(new Admin(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
                  }
              }
          }else {
               if (conn != null) {
                  pst = conn.prepareStatement(querry2);
                  pst.setString(1,"%"+key+"%" );
                  rs = pst.executeQuery();
                  while(rs.next()) {
                    list.add(new Admin(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
                  }
              }
          
          }
          
          }catch(SQLException ex) {
              ex.printStackTrace();
          }
         return list;
     }
    
    // ---> Update  Staff <--- //  
    public boolean updateStaff(Admin admin) {
        boolean check =false;
          Connection conn = null;
        PreparedStatement pst = null;
        conn = Dbutils.DbConnect.getConnection();
        String Querry = "  UPDATE Admin\n"
                + "  SET AD_ID = ? , AD_Name = ? , Password = ? ,RoleID = ?\n"
                + "  Where AD_ID = ?";
        try {
            if (conn != null) {
                pst = conn.prepareStatement(Querry);
                pst.setString(1, admin.getAd_ID());
                pst.setString(2, admin.getAd_Name());
                pst.setString(3, admin.getPassword());
                pst.setInt(4, admin.getRole());
                pst.setString(5, admin.getAd_ID());
                check =pst.executeUpdate() > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check;
        
    }
    
    //  ---->  Delete Staff <----- //
    public boolean  DeleteStaff(String ID) {
           boolean check =false;
          Connection conn = null;
        PreparedStatement pst = null;
        conn = Dbutils.DbConnect.getConnection();
        String Querry = "  DELETE \n"
                + "  FROM Admin\n"
                + "  Where AD_ID = ?";
        try {
            if (conn != null) {
                pst = conn.prepareStatement(Querry);
                pst.setString(1, ID);
          
                check =pst.executeUpdate() > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check;
    }
    
}
