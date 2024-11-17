/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer.CartDAO;
import model.Customer.Customer;
import org.apache.catalina.connector.Response;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "addToCart", urlPatterns = {"/addToCart"})
public class addToCart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(); 
       
        
        String P_ID = request.getParameter("ProductID");
        String C_ID = request.getParameter("CustomerID");
        int  quantity = 1;
        int oldQuantity = 0;
        String URL ="";
        String json ="";
        String Success ="";
        CartDAO dao = new CartDAO();
        boolean checkExist = dao.exists(C_ID,P_ID);
       
        Gson gson = new Gson();
    
      // Debug 
        System.out.println("ProductID : "+P_ID);
        System.out.println("CustomerID : "+C_ID);
        System.out.println("CheckExist : "+checkExist);
        
        // if exist in cart update quantity for cart
        // else if not exist will insert new Cart
        if(checkExist == true) {
           oldQuantity = dao.getOld_Quantity(C_ID, P_ID);
           oldQuantity++;
           boolean updateSuccess =dao.UpdateQuantity(oldQuantity, C_ID, P_ID);
           if (updateSuccess) {
               Success = "TRUE";
               json = gson.toJson(Success);   
           }
        }else {
            Success ="TRUE";
            dao.Insert(P_ID, C_ID, quantity);
            json = gson.toJson(Success);    
           
        }
     
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);        
        
        
        
        
        
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
