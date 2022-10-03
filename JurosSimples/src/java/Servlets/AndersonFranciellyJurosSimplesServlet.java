/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;


/**
 *
 * @author Fatec
 */
@WebServlet(name = "AndersonFranciellyJurosSimplesServlet", urlPatterns = {"/AndersonFranciellyJurosSimples.json"})
public class AndersonFranciellyJurosSimplesServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            
            String cap = request.getParameter("valor");
            double c = Double.parseDouble(cap);
            
            String jur = request.getParameter("juros");
            double j = Double.parseDouble(jur);
            
            String mes= request.getParameter("meses");
            int m = Integer.parseInt(mes);
            
            DecimalFormat decim =  new DecimalFormat();
            
            
            
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<Style> h2{color: lime}\n" +
"            body{background: linear-gradient(to right, blue, red);}\n" +
"            h4 {color: white} h3 {color: white}" + "</Style>");
            
            out.println("<title>Juros Simples</title>"); 
            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Juros Simples </h1>");        
            
            
            JSONObject file = new JSONObject();
            file.put(mes,m);
            file.put(cap, c);
            file.put(jur, j);
            double somJur = ((c*(j/100))*m);
            out.println("<h2>Capital: "+c+"</h2>");
            out.println("<h2>Juros: "+j+"</h2>");
            out.println("<h2>Meses: "+m+"</h2>");
            out.println("<h2>Juros: "+(decim.format((somJur)))+" </h2>");
            out.println("<h2>Valor Total a Pagar: "+(decim.format((somJur+c)))+" </h2>");
            
            out.println("<a href = 'index.html'><h3>Voltar</h3></a>");
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
