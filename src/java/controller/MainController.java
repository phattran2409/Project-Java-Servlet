/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

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
      
       String URL =""; 
       String action  = request.getParameter("action");
       if(action.equals("filter")) {
           URL="ShopFilter";
       }else if (action.equals("Category")) {
           URL ="Category";
       }else if (action.equals("onSale")) {
           URL ="Category";
       }else if(action.equals("Search Price")) {
           URL ="Category";
       }else if (action.equals("login")) {
           URL = "login";
       }else if (action.equals("add to cart")) {
           URL ="addToCart";
       }else if (action.equals("loadCart")) {
           URL ="loadCart";
       }else if (action.equals("search")) {
           URL = "Search";
       }else if (action.equals("loginAdmin")) {
           URL ="LoginAdmin";
       }else if (action.equals("update product")) {
           URL ="UpdateProduct";
       }else if(action.equals("remove product")) {
           URL ="RemoveProduct";
       }else if (action.equals("Search by Admin")){
           URL ="SearchProduct";
       }else if (action.equals("Insert New Product")) {
           URL ="InsertProduct";
       }else if (action.equals("Insert New Staff")) {
           URL = "InsertStaff";
       }else if (action.equals("Search Staff")) {
           URL ="SearchStaff";
       }else if (action.equals("update Staff")) {
           URL="UpdateStaff";
       }else if (action.equals("remove Staff")) {
           URL="RemoveStaff";
       }else if (action.equals("register")) {
           URL ="Register";
       }
       
       
       request.getRequestDispatcher(URL).forward(request, response);
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
