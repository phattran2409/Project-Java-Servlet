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
public class CartDAO {

    public CartDAO() {
    }
    
    
    public int CountCart(String CustomerId) {
        int count = 0 ;
        Connection conn =null; 
        PreparedStatement pst = null; 
        ResultSet  rs  = null; 
        String querry = "SELECT  c.P_ID ,p.P_Name,c.Quantity\n"
                + "	FROM Cart c JOIN Product p on c.P_ID  = p.P_ID\n"
                + "	WHERE c.C_ID = ?";
        conn = Dbutils.DbConnect.getConnection();
        try {
            if (conn != null) {
                pst = conn.prepareStatement(querry);
                pst.setString(1, CustomerId);
                rs = pst.executeQuery();
               while (rs.next()) {
                   count++;
               }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return  count;
    }
    
    // -----------> INSERT TO CART <------------//
    public void Insert(String P_ID , String C_ID , int quantity) {
       
        Connection conn =null; 
        PreparedStatement pst = null; 
        ResultSet  rs  = null; 
        String querry = "INSERT INTO  Cart(P_ID, C_ID ,Quantity) VALUES (? ,?,?);";
        conn = Dbutils.DbConnect.getConnection();
        try {
            if (conn != null) {
                pst = conn.prepareStatement(querry);
                pst.setString(1, P_ID);
                pst.setString(2, C_ID);
                pst.setInt(3, quantity);
                pst.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    // ---------> CHECK EXSITS <----------//
//    public boolean Exits(String C_ID ,String P_ID){
//        boolean check = true;
//        
//        int count = 0;
//        Connection conn =null; 
//        PreparedStatement pst = null; 
//        ResultSet  rs  = null; 
//        String querry = "SELECT *\n"
//                + "	FROM CART \n"
//                + "	WHERE  C_ID = ? AND  P_ID = ?";
//        conn = Dbutils.DbConnect.getConnection();
//        try {
//            if (conn != null) {
//                pst = conn.prepareStatement(querry);
//                pst.setString(1,C_ID );
//                pst.setString(2, P_ID);
//                rs = pst.executeQuery();
//                check = rs.next();
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//      return check; 
//    }
    
    public boolean exists(String C_ID, String P_ID) {
    boolean check = false;  // Initialize to false by default

    String query = "SELECT 1 FROM CART WHERE C_ID = ? AND P_ID = ?";
    
    try (Connection conn = Dbutils.DbConnect.getConnection();
         PreparedStatement pst = conn.prepareStatement(query)) {
        
        if (conn != null) {
            pst.setString(1, C_ID);
            pst.setString(2, P_ID);

            try (ResultSet rs = pst.executeQuery()) {
                check = rs.next();  // If a record is found, check will be true
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return check;
}
    
    // -----------> UPDATE QUANTITY to CART <---------------- // 
    public boolean UpdateQuantity(int Quantity , String C_ID ,String P_ID ) {
        boolean check = false;
        String querry = "Update Cart  \n"
                + "	Set  Quantity = ?\n"
                + "	WHERE C_ID = ? AND P_ID =?";
           try (Connection conn = Dbutils.DbConnect.getConnection();
         PreparedStatement pst = conn.prepareStatement(querry)) {
        
        if (conn != null) {
            pst.setInt(1, Quantity);
            pst.setString(2, C_ID);
            pst.setString(3, P_ID);
            
            check = pst.executeUpdate() > 0 ? true :false ;
            
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
        return check;
    }
    
    
// --------->  Get entity Cart <----------// 
//    public CartDTO getCart() {
//        CartDTO cart = null;
//        String querry = "SELECT C_ID , P_ID\n"
//                + "	FROM CART \n"
//                + "	WHERE  C_ID = 'AndyChen123' AND P_ID=  'JD_005' ";
//        try (
//                Connection conn = Dbutils.DbConnect.getConnection();
//                PreparedStatement pst = conn.prepareStatement(query)) {
//            
//            if (conn != null) {
//                pst.setString(1, C_ID);
//                pst.setString(2, P_ID);
//
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
    
//    ------------> get quantity <------------// 
    
    
    public int getOld_Quantity(String C_ID , String P_ID){
        int oldQuantity = 0;
        String query = "SELECT Quantity FROM CART WHERE C_ID = ? AND P_ID = ?";

        try (Connection conn = Dbutils.DbConnect.getConnection(); 
            PreparedStatement pst = conn.prepareStatement(query)) {

            if (conn != null) {
                pst.setString(1, C_ID);
                pst.setString(2, P_ID);
                 ResultSet rs = pst.executeQuery(); 
                if (rs.next()) {
                    oldQuantity  = rs.getInt(1);
                    return oldQuantity;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return oldQuantity;
    }
    
    // -------> load Cart <--------- // 
    
    public List<Product>  LoadCart(String C_ID) {
       List<Product> list = new ArrayList<>();
       Connection conn =null; 
       PreparedStatement  pst = null; 
       ResultSet rs =null; 
       
        String querry = "	SELECT  C.P_ID ,p.P_Name , p.image,P.Brand , C.Quantity , P.Price,P.discount ,P.Show \n"
                + "	FROM Cart c JOIN Product p on c.P_ID  = p.P_ID\n"
                + "	WHERE c.C_ID = ? ";
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
    
    // ---------> Delete Cart <----------- // 
    public boolean DeleteCart(String C_ID , String P_ID) {
        boolean check = false;
        String Querry="DELETE FROM Cart WHERE C_ID = ? AND P_ID = ?";
        try {
            Connection conn = Dbutils.DbConnect.getConnection();
            PreparedStatement pst = null;
            if (conn != null) {
               pst = conn.prepareStatement(Querry );
               pst.setString(1, C_ID);
               pst.setString(2 , P_ID);
               if(pst.executeUpdate() > 0) {
                   check =true;
               }
            }
        }catch(SQLException ex) {
        }
        
        return check;
    }
    
    
    
    
    
    public static void main(String[] args) {
        CartDAO d = new CartDAO();
        int  count = d.CountCart("AndyChen123");
        System.out.println("COUNT "+count);
        
       
    }
}
