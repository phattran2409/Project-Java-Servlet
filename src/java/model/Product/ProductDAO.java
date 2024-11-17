/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Product;

import Dbutils.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ProductDAO {
    
    public static List<Product> getAllProduct() {
        List<Product> list  = new ArrayList<>();
       Connection conn = null;
       PreparedStatement pst = null; 
       ResultSet rs = null; 
       String querry = "SELECT P_ID  , P_Name , image , Brand, Quantity , Price , discount , Show  FROM Product";
               
       try  {
            conn = Dbutils.DbConnect.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(querry); 
                rs = pst.executeQuery(); 
                while (rs.next()) {
                    list.add( new Product(rs.getString(1), rs.getString(2),rs.getString(3) , rs.getString(4), rs.getInt(5),rs.getDouble(6), rs.getDouble(7), rs.getInt(8)));
                }
            }
       }catch(SQLException e) {
           e.printStackTrace();
       }
       return list;
    }
//    Pagination 
       // count all product
      public  int count() {
          int count = 0; 
          String querry  = "SELECT COUNT(*) FROM  Product";
          Connection conn =null; 
          PreparedStatement pst = null; 
          ResultSet rs = null; 
          
          conn = DbConnect.getConnection();
          try { 
          if (conn != null) {
              pst = conn.prepareStatement(querry); 
              rs = pst.executeQuery();
             if (rs.next()) {
                 count  = rs.getInt(1);
             }
          }
          }catch(SQLException ex) {
              ex.printStackTrace();
          }
          
         
          return count;
      }
      // OFFSET 
     public   List<Product> getLimitProduct(int index) {
        List<Product> list = new ArrayList<>();
        Connection conn  =null; 
        PreparedStatement pst = null; 
        ResultSet rs = null; 
         String querry1 = "SELECT P_ID  , P_Name , image , Brand, Quantity , Price , discount , Show  FROM Product\n"
                 + "ORDER BY P_Name\n"
                 + "OFFSET ? ROW FETCH NEXT 6 ROWS ONLY";
        try {
            conn  = DbConnect.getConnection(); 
      
                pst = conn.prepareStatement(querry1);
                //  1  ->  offset  0  ( 0 -1 ) * 3
                //  2 ->  offset 3 
                // 3 -> offset  6
                pst.setInt(1, (index - 1) * 6);
                rs = pst.executeQuery();
                while (rs.next()) {
                    list.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getDouble(7), rs.getInt(8)));
                }
           
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
   //  ----------> FILTER <--------------
     
     public List<Product> get_Filter_Feature(int index , String option) {
        List<Product> list = new ArrayList<>();
        Connection conn  =null; 
        PreparedStatement pst1 = null; 
        PreparedStatement pst2 = null;
        PreparedStatement pst3 = null;
        ResultSet rs3 = null;
        ResultSet rs2 = null;
        ResultSet rs1 = null; 
         String querry1 = "SELECT P_ID  , P_Name , image , Brand, Quantity , Price , discount , Show  FROM Product\n"
                 + "ORDER BY  Price DESC, discount  DESC \n"
                 + "OFFSET ? ROW  FETCH NEXT 6 ROWS ONLY";
         String querry2 = "SELECT P_ID  , P_Name , image , Brand, Quantity , Price , discount , Show  FROM Product\n"
                 + "ORDER BY P_Name ASC\n"
                 + "OFFSET ? ROW  FETCH NEXT 6 ROWS ONLY";
         String querry3 = "SELECT P_ID  , P_Name , image , Brand, Quantity , Price , discount , Show  FROM Product\n"
                 + "ORDER BY P_Name DESC\n"
                 + "OFFSET ? ROW  FETCH NEXT 6 ROWS ONLY";
        try {
            conn  = DbConnect.getConnection();
       
            if (option.equals("featured")) {
                pst1 = conn.prepareStatement(querry1);
               
                pst1.setInt(1, index);
                rs1 = pst1.executeQuery();
                while (rs1.next()) {
                    list.add(new Product(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getInt(5), rs1.getDouble(6), rs1.getDouble(7), rs1.getInt(8)));
                }
            }else if (option.equals("AtoZ")) {
                pst2 =  conn.prepareStatement(querry2);
                pst2.setInt(1, index );
                rs2 = pst2.executeQuery();
                while (rs2.next()) {
                    list.add(new Product(rs2.getString(1), rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getInt(5), rs2.getDouble(6), rs2.getDouble(7), rs2.getInt(8)));
                }
            }else if (option.equals("ZtoA")) {
                pst3 = conn.prepareStatement(querry3);
                pst3.setInt(1, index );
                rs3 = pst3.executeQuery();
                while (rs3.next()) {
                    list.add(new Product(rs3.getString(1), rs3.getString(2), rs3.getString(3), rs3.getString(4), rs3.getInt(5), rs3.getDouble(6), rs3.getDouble(7), rs3.getInt(8)));
                }
            }
            
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
     
    // ----------> CATEGORY PRODUCT <----------------- //
     public List<Product> getProductByCategory(String id ,  int  index){
         List<Product> list = new ArrayList<>();
         Connection conn = null; 
         PreparedStatement pst = null; 
         ResultSet rs = null; 
         String querry = "SELECT P_ID  , P_Name , image , Brand, Quantity , Price , discount , Show  FROM Product\n"
                 + "WHERE Cate_ID  = ?\n"
                 + "ORDER BY P_Name DESC\n"
                 + "OFFSET ? ROW  FETCH NEXT 6 ROWS ONLY";
        try {
            conn = Dbutils.DbConnect.getConnection(); 
           if (conn != null) {
               pst =  conn.prepareStatement(querry);
               pst.setString(1, id);
               pst.setInt(2, index);
               rs = pst.executeQuery();
               while (rs.next()) {
                   list.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getDouble(7), rs.getInt(8)));
               }
           }
         }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
     }
    
     
     // ----------> CATEGORY ONSALE <--------- // 
       public List<Product> getProductByCategory_onSale(String id ,  int  index){
         List<Product> list = new ArrayList<>();
         Connection conn = null; 
         PreparedStatement pst = null; 
         ResultSet rs = null; 
           String querry = "	SELECT P_ID  , P_Name , image , Brand, Quantity , Price , discount , Show  FROM Product\n"
                   + "	WHERE Cate_ID  = ? AND discount > 0\n"
                   + "	ORDER BY P_Name DESC , discount DESC\n"
                   + "	OFFSET ? ROW  FETCH NEXT 6 ROWS ONLY";
        try {
            conn = Dbutils.DbConnect.getConnection(); 
           if (conn != null) {
               pst =  conn.prepareStatement(querry);
               pst.setString(1, id);
               pst.setInt(2, (index-1)*6);
               rs = pst.executeQuery();
               while (rs.next()) {
                   list.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getDouble(7), rs.getInt(8)));
               }
           }
         }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
     }
     // -------------> Search by price <-------------- // 
         public List<Product> getProductByCategory_Price( int price1 , int price2 , int index){
         List<Product> list = new ArrayList<>();
         Connection conn = null; 
         PreparedStatement pst = null; 
          PreparedStatement pst2 = null; 
         ResultSet rs = null; 
         ResultSet rs2 = null; 
           String querry = "	SELECT P_ID  , P_Name , image , Brand, Quantity , Price , discount , Show  FROM Product\n"
                   + "	WHERE Price between ? and ?\n"
                   + "	ORDER BY Price DESC \n"
                   + "	OFFSET ? ROW  FETCH NEXT 6 ROWS ONLY";
        
        try {
            conn = Dbutils.DbConnect.getConnection(); 
           if (conn != null) {
              
               pst = conn.prepareStatement(querry);
               pst.setInt(1, price1);
               pst.setInt(2, price2);
               pst.setInt(3, (index-1)*6);
               rs = pst.executeQuery();
               while (rs.next()) {
                   list.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getDouble(7), rs.getInt(8)));
               }
             
           }
         }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
     }
        
         
    public int Count_Search(int price1 , int price2 ) {
        int count = 0;
         Connection conn = null; 
         PreparedStatement pst = null; 
          PreparedStatement pst2 = null; 
         ResultSet rs = null; 
         ResultSet rs2 = null; 
           String querry = "	SELECT COUNT(*)\n"
                   +" FROM Product\n"
                   + "WHERE Price between ? and ?\n";
 
                
                  
        try {
            conn = Dbutils.DbConnect.getConnection(); 
           if (conn != null) {
        
               pst = conn.prepareStatement(querry);
               pst.setInt(1, price1);
               pst.setInt(2, price2);
               rs = pst.executeQuery();
                  if  (rs.next()) {
                   count  = rs.getInt(1);
              
               }
              
           }
         }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return count;
    }          
    
         public List<Product> getProductCategory_LoadMore_Price( int price1 , int price2 , int index){
         List<Product> list = new ArrayList<>();
         Connection conn = null; 
         PreparedStatement pst = null; 
          PreparedStatement pst2 = null; 
         ResultSet rs = null; 
         ResultSet rs2 = null; 
           String querry = "	SELECT P_ID  , P_Name , image , Brand, Quantity , Price , discount , Show  FROM Product\n"
                   + "	WHERE Price between ? and ?\n"
                   + "	ORDER BY Price DESC \n"
                   + "	OFFSET ? ROW  FETCH NEXT 6 ROWS ONLY";
        
        try {
            conn = Dbutils.DbConnect.getConnection(); 
           if (conn != null) {
              
               pst = conn.prepareStatement(querry);
               pst.setInt(1, price1);
               pst.setInt(2, price2);
               pst.setInt(3, index);
               rs = pst.executeQuery();
               while (rs.next()) {
                   list.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getDouble(7), rs.getInt(8)));
               }
             
           }
         }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
     }
     // ----------->  SEARCH PPODUCT BY NAME -----------> ///
         public List<Product> getSearchProductByName(String  P_Name) {
             List<Product> list = new ArrayList();
             String querry = "SELECT P_ID  , P_Name , image , Brand, Quantity , Price , discount , Show  FROM Product\n"
                     + "Where P_Name LIKE ?";
             ResultSet rs = null;
             try {
                 Connection conn = DbConnect.getConnection();
                 if (conn != null ) {
                     PreparedStatement pst = conn.prepareStatement(querry);
                     pst.setString(1, "%"+P_Name+"%");
                     rs = pst.executeQuery();
                     while(rs.next()) {
                          list.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getDouble(7), rs.getInt(8)));
                     }
                 }
             }catch(SQLException ex) {
             }
             return list;
         }
         
      // -----------> ADMIN <--------------- // 
       public boolean UpdateProductByAdmin(Product P){ 
          boolean check = false;
         Connection conn = null; 
         PreparedStatement pst = null; 
       
         ResultSet rs = null; 
     
           String querry = " UPDATE Product\n"
                   + " SET P_ID = ?  ,P_Name = ? ,image = ? ,Brand = ? ,Price = ? ,discount= ?,Quantity = ?,Show = ? \n"
                   + " WHERE P_ID = ?";
        
        try {
            conn = Dbutils.DbConnect.getConnection(); 
           if (conn != null) {
              
               pst = conn.prepareStatement(querry);
               pst.setString(1, P.getProductID());
               pst.setString(2, P.getProductName());
               pst.setString(3, P.getImage());
               pst.setString(4, P.getBrand());
               pst.setDouble(5, P.getPrice());
               pst.setDouble(6, P.getDiscount());
               pst.setInt(7, P.getQuantity());
               pst.setInt(8, P.getShow());
               pst.setString(9, P.getProductID());
                if (pst.executeUpdate() > 0) {
                    check =true;
                }
             
           }
         }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
           return check;   
      }
       
     public boolean RemoveProductByAdmin(String ID) {
         boolean  check  = false;
         Connection conn = null;
         PreparedStatement pst = null; 
         String Querry = " DELETE FROM Product\n"
                 + " where P_ID = ?";
         conn = Dbutils.DbConnect.getConnection();
         try {
             if (conn != null) {
                pst = conn.prepareStatement(Querry);
                pst.setString(1, ID);
                if(pst.executeUpdate() > 0) {
                    check = true;
                }
             }
         }catch (SQLException ex) {
             ex.printStackTrace();
         }
         return check;
     }
         
     public List<Product> SearchProductByAdmin(String key , String option){
           List<Product> list = new ArrayList<>();
          Connection conn = null;
          PreparedStatement pst = null;
          ResultSet rs = null;
          String querry = "SELECT P_ID  , P_Name , image , Brand, Quantity , Price , discount , Show  FROM Product P  WHERE P_Name LIKE ? ";
          String querry2 = "SELECT P_ID  , P_Name , image , Brand, Quantity , Price , discount , Show  FROM Product P  WHERE P_ID LIKE ? ";
          conn  = DbConnect.getConnection();
          try {
          if (option.equals("Name")) { 
              if (conn != null) {
                  pst = conn.prepareStatement(querry);
                  pst.setString(1, "%"+key+"%");
                  rs = pst.executeQuery();
                  while(rs.next()) {
                    list.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getDouble(7), rs.getInt(8)));
                  }
              }
          }else {
               if (conn != null) {
                  pst = conn.prepareStatement(querry2);
                  pst.setString(1,"%"+key+"%" );
                  rs = pst.executeQuery();
                  while(rs.next()) {
                    list.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getDouble(7), rs.getInt(8)));
                  }
              }
          
          }
          
          }catch(SQLException ex) {
              ex.printStackTrace();
          }
         return list;
     }
    // -----> Insert Product <---- // 
     public boolean InsertNewProduct(Product P , String Cate_id) {
         boolean check = false;
         Connection conn = null;
         PreparedStatement pst = null;
          conn = DbConnect.getConnection(); 
          String querry ="INSERT INTO Product(P_ID,P_Name,image,Brand,Price,discount,Quantity,Show,Cate_ID) VALUES (?,? ,? ,? ,? ,? ,? ,? ,?)";
        
         try {
             if (conn != null) {
               pst = conn.prepareStatement(querry);
               pst.setString(1, P.getProductID());
               pst.setString(2, P.getProductName());
               pst.setString(3, P.getImage());
               pst.setString(4, P.getBrand());
               pst.setDouble(5, P.getPrice());
               pst.setDouble(6, P.getDiscount());
               pst.setInt(7, P.getQuantity());
               pst.setInt(8, P.getShow());
               pst.setString(9, Cate_id);
               if (pst.executeUpdate() > 0 ) {
                   check  =true;
               }
             }
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
         
        return  check;
     }
         
         
         
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
          ProductDAO dao = new ProductDAO();
       
         list = dao.getSearchProductByName("Nike");
         for (Product x : list) {
             System.out.println("product ID : "+x.getProductID());
         }
    }
}
