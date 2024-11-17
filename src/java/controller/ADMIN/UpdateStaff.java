/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.ADMIN;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "UpdateStaff", urlPatterns = {"/UpdateStaff"})
public class UpdateStaff extends HttpServlet {

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
        String pass =""; 
        String passCurrent="";
        if(request.getParameter("Pass") != null) {
            System.out.println("lay dc gia tri pass");
            pass = (String) request.getParameter("Pass");
        }
        int role = Integer.parseInt(request.getParameter("role"));
        String message = "";
        AdminDAO Dao = new AdminDAO();
        // CASE they  Not Update Password , Password not change
        if (pass.contains("***")) {
            System.out.println("if block pass");
            passCurrent = getPassCurrent(Ad_ID);
            pass = passCurrent;
        }
        
        Admin admin = new Admin(Ad_ID, Ad_Name, pass, role);
        boolean check = false;
        check = Dao.updateStaff(admin);
        // debug ]
        System.out.println("Pass not edit "+pass);
//        if(check) {
//            message = "Update Staff " + Ad_ID +"SuccessFull";
//        }
        request.setAttribute("message", message);
        request.getRequestDispatcher("LoadStaff").forward(request, response);
    }
    
    
     static String getPassCurrent( String Ad_ID){ 
      AdminDAO dao= new AdminDAO();
       List<Admin> list = dao.loadStaff();
       String pass ="";
        for (Admin ad : list) {
            if (ad.getAd_ID().contains(Ad_ID)) {
                pass = ad.getPassword();
            }

        }
        return  pass;

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
