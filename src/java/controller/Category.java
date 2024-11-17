/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Product.CategoryDAO;
import model.Product.Product;
import model.Product.ProductDAO;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "Category", urlPatterns = {"/Category"})
public class Category extends HttpServlet {

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
       String CateID  = "";
         if (request.getParameter("CateID")!= null ) {
             CateID  = request.getParameter("CateID");
         }
       String action = "";
         if(request.getParameter("action")!= null) {
             action = request.getParameter("action");
         }

        int tabIndex = 1;
        if (request.getParameter("tabIndex") != null) {
            tabIndex = Integer.parseInt(request.getParameter("tabIndex"));
        }else {
            tabIndex = 1;
        }   
       List<Product> list = null; 
       ProductDAO dao = new ProductDAO();
            
        
        System.out.println("action "+action);
        System.out.println("TabIndex : "+tabIndex);
        // creat Session store phien lam viec
        HttpSession session = request.getSession();
        if (action.equals("Category")) {
                  // get Tab index 
            if (request.getParameter("tabindex") != null) {
               tabIndex = Integer.parseInt(request.getParameter("tabindex"));
            }
            list = dao.getProductByCategory(CateID, tabIndex);
//            for (Product x : list) {
//                System.out.println(x.getProductName());
//            }
            
        }else if (action.equals("onSale")) {
    
                  // get Tab index 
            if (request.getParameter("tabindex") != null) {
               tabIndex = Integer.parseInt(request.getParameter("tabindex"));
            }
            list = dao.getProductByCategory_onSale(CateID, tabIndex);
            
          
        }else if (action.equals("Search Price")) {
    
            String price = request.getParameter("price"); 

            String[] price_Arr = price.split("-");
            
            int price1 = 0 , price2 = 0;
            
            price1 = Integer.parseInt(price_Arr[0]);
            price2 = Integer.parseInt(price_Arr[1]);
            
            //debug 
            System.out.println("prrice1 " + price1);
            System.out.println("price2 "+price2);
            // get Tab index 
       
          
            
                list = dao.getProductByCategory_Price(price1, price2, tabIndex);
         
             

            // total product in search by price 
         
           request.setAttribute("price1", price1);
           request.setAttribute("price2", price2);
       
            
 
        }
     
     request.setAttribute("list", list);
     session.setAttribute("CateID", CateID);
     request.setAttribute("action",action);
     request.setAttribute("option", "Category");
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
