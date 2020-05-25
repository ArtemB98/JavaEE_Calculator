package web_classes;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Locale;

/**
 *
 * @author 123
 */
@WebServlet(name = "res_Servlet", urlPatterns = {"/res_Servlet"})
public class res_Servlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet res_Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet res_Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String f,s;
        boolean flag = false;
        MyObj a = (MyObj)request.getSession().getAttribute("obj");
        PrintWriter out = response.getWriter();
        try 
        {
           if(a.get_oper() == 1)
               a.set_res(Double.toString(Double.parseDouble(a.get_f()) + Double.parseDouble(a.get_s())));
           else if(a.get_oper() == 2)
            a.set_res(Double.toString(Double.parseDouble(a.get_f()) - Double.parseDouble(a.get_s())));
           else if(a.get_oper() == 3)
            a.set_res(Double.toString(Double.parseDouble(a.get_f()) * Double.parseDouble(a.get_s())));
           else
            a.set_res(Double.toString(Double.parseDouble(a.get_f()) / Double.parseDouble(a.get_s())));
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        }
        catch (Exception ex)
        {
            a.set_res("Error!");
            request.getRequestDispatcher("/result.jsp").forward(request, response);
            //ex.printStackTrace(out);
            }
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
