/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lendle.courses.network.requestparameterservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lendle
 */
@WebServlet(name = "ProcessServlet", urlPatterns = {"/process"})
public class ProcessServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProcessServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            Enumeration<String>names=request.getParameterNames();// Enumeration是簡單的array
            while(names.hasMoreElements()){
                String name=names.nextElement();
                out.println(name+"=");
                out.print(request.getParameter(name)+"<br/>");//取得name送過來的參數+換行
                //http://localhost:8080/RequestParameterServlet/process?username=lendle&abc=123
            }
            out.println(request.getParameter("username"));//取得user送過來的參數
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}
