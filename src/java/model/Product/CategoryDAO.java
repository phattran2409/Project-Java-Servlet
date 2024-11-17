/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Product;

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
public class CategoryDAO {

    public CategoryDAO() {
    }
  
    public List<Category> getCategoryName(){
        List<Category> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null; 
        ResultSet  rs =null; 
        String querry = "SELECT * FROM Category";
        try {
            conn = Dbutils.DbConnect.getConnection();        
            if (conn != null) {
                pst = conn.prepareStatement(querry);
                rs = pst.executeQuery();
                while (rs.next()) {
                   list.add(new Category(rs.getString(1), rs.getString(2)));
                }
            }
        }catch (SQLException ex) {
             ex.printStackTrace();
             
        }

        return list;
    }
    

    
}
