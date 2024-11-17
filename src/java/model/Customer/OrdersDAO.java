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


/**
 *
 * @author ADMIN
 */
public class OrdersDAO {
    public void Insert(Orders O , List<OdersDetails> L_orderDetails ){
        boolean check =false;
        Connection conn = Dbutils.DbConnect.getConnection();
        String querry = "INSERT INTO Orders(O_ID,C_ID,Date,Total) VALUES (? , ? , ? ,?)";
       String querry2 = " INSERT INTO ordersDetail(O_ID , P_ID , Price , Quantity) VALUES (?, ? ,?, ?)";
       java.util.Date utilDate = new java.util.Date();
       java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
       
        try {
           
        if (conn != null) {
          PreparedStatement pst = conn.prepareStatement(querry);
          pst.setString( 1,O.getO_ID());
          pst.setString( 2, O.getC_ID());
          pst.setDate(3, sqlDate);
          pst.setFloat(4, O.getTotal());
          pst.executeUpdate();
          
          for (OdersDetails orders : L_orderDetails) { 
          PreparedStatement pst2 = conn.prepareStatement(querry2); 
          pst2.setString(1, orders.getO_ID());
          pst2.setString(2, orders.getP_ID());
          pst2.setDouble(3, orders.getPrice());
          pst2.setInt(4, orders.getQuantity());
          pst2.executeUpdate();
          }
         }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
    public  List<OdersDetails> Load(String C_ID) {
        List<OdersDetails> list  = new ArrayList<>();
        Connection conn = Dbutils.DbConnect.getConnection();
        String querry = " SELECT  OD.O_ID ,  OD.P_ID , OD.Quantity , OD.Price\n"
                + "  from  Orders  O JOIN   ordersDetail OD on O.O_ID = OD.O_ID\n"
                + "  where O.C_ID = ? ";
        ResultSet rs = null;
        try { 
        if (conn != null) {
            PreparedStatement  pst  = conn.prepareStatement(querry);
            pst.setString(1, C_ID);
            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new OdersDetails(rs.getString(1),rs.getString(2), rs.getInt(3),rs.getDouble(4) ));
            }
            
        }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
