/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.sun.jmx.remote.internal.ArrayQueue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Product.ProductDAO;
import model.Product.Product;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "shop", urlPatterns = {"/shop"})
public class shop extends HttpServlet {

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
      
        
        
        List<Product>  list = new ArrayList<>();
        ProductDAO  dao = new ProductDAO(); 
        int tabIndex = 1;
        try {
           
            String option = "";
            HttpSession sessionn =  request.getSession();
            // get index tab index from JSP 
           if (  request.getParameter("tagIndex") != null ) {
             tabIndex  = Integer.parseInt(request.getParameter("tagIndex"));
               
            }else {
              tabIndex = 1;  
           } 
           
           // get  value of  option 
           if (request.getParameter("option") != null) {
               option =  request.getParameter("option");
           }
          
       // ---------> FILTER <-------------//
       if(option.equals("featured")) { 
          
           list = dao.get_Filter_Feature(tabIndex ,option);
       }else if (option.equals("AtoZ")) {
           list = dao.get_Filter_Feature(tabIndex, option);
       }else if (option.equals("ZtoA")) {
           list = dao.get_Filter_Feature(tabIndex, option);
       }
       
       // -----------> CATEGORY PRODUCT <--------- //
       
      String cateID = "";
       if (request.getParameter("option") != null) {
               option =  request.getParameter("option");
      }
      if (request.getParameter("cateID") != null) {
           cateID  = request.getParameter("cateID");
      }
      if  (option.equals("Category")) { 
         
         list = dao.getProductByCategory(cateID,tabIndex);
         
       }
        
       //
        if (option.isEmpty()){
         list   = dao.getLimitProduct(tabIndex );
        }
        
       
        }catch(NumberFormatException ex) {
            ex.printStackTrace();
        }
       request.setAttribute("list", list);
       request.setAttribute("tabindex", tabIndex);
       request.getRequestDispatcher("shop.jsp").forward(request, response);
        
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
