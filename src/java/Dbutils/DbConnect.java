/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class DbConnect {
   public static Connection getConnection() {
         Connection conn = null; 
        try {
                
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());

            String dbURL = "jdbc:sqlserver://DESKTOP-9HSQ90N\\PHAT:1433;encrypt=true;trustServerCertificate=true;databaseName=Project01";
            String user = "sa";
            String pass = "123";
             conn = DriverManager.getConnection(dbURL, user, pass);
            
            } catch (SQLException e) {
                System.out.println("Errors connect to database");
            } 
        
         return conn;
   }
   
    public static void main(String[] args) {
        Connection conn = DbConnect.getConnection();
        
        
        if (conn  != null) {
            System.out.println("SUCCESS");
        }
                
    }
}
