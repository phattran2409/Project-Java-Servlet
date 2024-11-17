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
import model.ADMIN.Admin;
import model.ADMIN.AdminDAO;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "InsertStaff", urlPatterns = {"/InsertStaff"})
public class InsertStaff extends HttpServlet {

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
       String Ad_ID = request.getParameter("S_ID"); 
       String Ad_Name = request.getParameter("S_Name");
       String pass = request.getParameter("pass"); 
       int role = Integer.parseInt(request.getParameter("role"));
        AdminDAO Dao = new AdminDAO();
        Admin  Staff =  null;
        boolean  Exist = Dao.Exist(Ad_ID);
        String message1 = "";
        String message2 ="";
        
        Staff = new Admin(Ad_ID, Ad_Name, pass, role);
        // Debug 
        System.out.println(" staff ID "+Ad_ID);
        System.out.println(Exist );
        if (!Exist) {
           
          boolean   check = Dao.InsertStaff(Staff);
           if(check) {
                message2 = "Create a Staff Success";
           }
        }else{
            message1 ="Staff Id was Exist , Please Enter Again !! ";
            message2 ="Can't Create a new Staff !!!";
        }
        
        request.setAttribute("DuplicateMessage", message1);
        request.setAttribute("message", message2);
        request.getRequestDispatcher("LoadStaff").forward(request, response);
       
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
