/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.ADMIN;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "InsertProduct", urlPatterns = {"/InsertProduct"})
public class InsertProduct extends HttpServlet {

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
        
      
            /* TODO output your page here. You may use following sample code. */
            String P_ID = request.getParameter("P_ID");
            String P_Name = request.getParameter("P_Name");
            String Image = request.getParameter("image");
            String Brand = request.getParameter("Brand");
            double Price = Double.parseDouble(request.getParameter("Price"));
            double discount = Double.parseDouble(request.getParameter("Discount"));
            int Quantity = Integer.parseInt(request.getParameter("Quantity"));
            int show = Integer.parseInt(request.getParameter("show"));
            String Cate_Id = request.getParameter("Cate_ID");
            ProductDAO dao = new ProductDAO();
            double newDiscount = 0 ;
            if (discount >  0 )  {
                newDiscount = discount/ 100;
            }
            
            Product P = new Product(P_ID, P_Name, Image, Brand, Quantity, Price, newDiscount, show);
            boolean check = dao.InsertNewProduct(P, Cate_Id);
            String message ="";
            if (check) {
                message = "Inserted a new Product Success !";
            }
            request.setAttribute("message", message);
            request.getRequestDispatcher("LoadProduct").forward(request, response);
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
