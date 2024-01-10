/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author HI
 */
@WebServlet(name = "CalServlet", urlPatterns = {"/CalServlet"})
public class CalServlet extends HttpServlet {

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
            out.println("<title>Servlet CalServlet</title>");
            out.println("</head>");
            out.println("<body>");
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
        String operator = request.getParameter("operator");
        String first = "";
        String second ="";
        String result = "";
        try {
            first = request.getParameter("first");
            second = request.getParameter("second");
            result = calculate(first, second, operator);
        } catch (Exception e) {
            first = "";
            second = "";
            result = "";
        }
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.println("<form action='CalServlet'>");
            out.println("<label for=\"first\">First:</label>");
            out.println("<input type=\"number\" name=\"first\" value='"+ first +"'><br>");
            out.println("<label for=\"second\">Second:</label>");
            out.println("<input type=\"number\" name=\"second\" value='"+ second +"'><br>");
            out.println("<label for=\"operator\">Operator</label>");
            out.println("<select id=\"operator\" name=\"operator\" >");
            out.println("<option " + ("+".equals(operator) ? "selected" : "") + " value=\"+\">+</option>");
            out.println("<option " + ("-".equals(operator) ? "selected" : "") + " value=\"-\">-</option>");
            out.println("<option " + ("*".equals(operator) ? "selected" : "") + " value=\"*\">*</option>");
            out.println("<option " + ("/".equals(operator) ? "selected" : "") + " value=\"/\">/</option>");
            out.println("<option " + ("^".equals(operator) ? "selected" : "") + " value=\"^\">^</option>");
            out.println("</select><br><br>");
            out.println("<input type=\"submit\" value=\"Compute\"><br><br>");
            out.print("<label for=\"result\">Result:</label>");
            out.println("<input type=\"text\" name=\"result\" value='" + result + "'>");
            out.println("</form>");
        }
    }

    private String calculate(String first, String second, String operator) {
        String result = "";
        double firstNum = Double.parseDouble(first);
        double secondNum = Double.parseDouble(second);
        switch (operator) {
            case "+":
                result = String.valueOf(firstNum + secondNum);
                break;
            case "-":
                result = String.valueOf(firstNum - secondNum);
                break;
            case "*":
                result = String.valueOf(firstNum * secondNum);
                break;

            case "/":
                result = String.valueOf(firstNum / secondNum);
                break;
            case "^":
                if (secondNum == 0) {
                    result = "1";
                } else {
                    for (int i = 1; i < secondNum; i++) {
                        firstNum *= Double.parseDouble(first);
                    }
                    result = String.valueOf(firstNum);
                }

                break;
        }
        return result;
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
