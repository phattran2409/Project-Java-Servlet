/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product.Product;
import model.Product.ProductDAO;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "loadMore", urlPatterns = {"/loadMore"})
public class loadMore extends HttpServlet {

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
        int price1 = 0, price2 = 0 , tabindex= 1;
        
        if ((request.getParameter("price1")!= null && request.getParameter("price2") != null )) {
            price1 = Integer.parseInt(request.getParameter("price1"));
            price2 = Integer.parseInt(request.getParameter("price2"));
           
        }
        if (request.getParameter("tabindex")!= null) {
             tabindex = Integer.parseInt(request.getParameter("tabindex"));
        }
        // --->  variable action create
        String action ="";
        if(request.getParameter("action") !=  null) {
            action = request.getParameter("action");
        }
        String option ="";
        // ---> variable option create
        if (request.getParameter("option") != null) {
            option = request.getParameter("option");
        }
         // ---> variable cateId create 
         String cateId = ""; 
         if (request.getParameter("cateId") != null) {
            
             cateId = request.getParameter("cateId");
         }
         
        List<Product> list = new ArrayList(); 
        ProductDAO dao  = new ProductDAO();
        
        // ---------> load more for filterr
        System.out.println("action : "+action);
        System.out.println("option :"+option);  
        System.out.println("tabindex : "+tabindex);
        System.out.println("Cate ID "+cateId);
        if(action.equals("filter")) {
            int tabindex2 = Integer.parseInt( request.getParameter("tabindex"));
            System.out.println("tabindex "+ tabindex2);
            list = dao.get_Filter_Feature(tabindex2,option );
        }else {
         list = dao.getProductCategory_LoadMore_Price(price1, price2, tabindex); 
        }   
        
 

        
        request.setAttribute("list", list);
        request.getRequestDispatcher("SearchByPrice.jsp").forward(request, response);
           
        
     
         
        
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
