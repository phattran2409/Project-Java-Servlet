/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer.CartDAO;
import model.Customer.Customer;
import model.Customer.OdersDetails;
import model.Customer.OrdersDAO;
import model.Customer.Orders;
import model.Product.Product;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "Oders", urlPatterns = {"/Oders"})
public class Oders extends HttpServlet {

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
        HttpSession session  = request.getSession();
        String O_ID = Dbutils.UniqueRandomIdGenerator.getUniqueRandomId();
        float total = Float.parseFloat(request.getParameter("total"));
        Customer customer = (Customer) session.getAttribute("loginUser");
        OrdersDAO dao = new OrdersDAO(); 
        Orders O = null;
        CartDAO cartDao = new CartDAO();
        List<Product>  listCart = cartDao.LoadCart(customer.getID());
        List<OdersDetails>  L_odersDetail = new ArrayList<>();
        Gson gson = new Gson();
        String Json = "";
        //debug 
        System.out.println("O_ID :"+O_ID);
         if(customer  != null) { 
            O = new Orders(O_ID, customer.getID(), total);

            for (Product p : listCart) {
                double  newPrice = 0;
                if (p.getDiscount() >  0  ) {
                    newPrice = p.getNewPrice() * p.getQuantity();
                }else {
                    newPrice = p.getPrice() * p.getQuantity();
                }
                L_odersDetail.add(new OdersDetails(O_ID , p.getProductID() , p.getQuantity() ,newPrice  ));
            }
         }
         dao.Insert(O, L_odersDetail);
         String Success ="TRUE"; 
         Json  = gson.toJson(Success);
         response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(Json);       
         
         //debug 
        
             
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
