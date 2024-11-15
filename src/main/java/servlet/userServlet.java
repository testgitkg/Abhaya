/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import ejb.userLocal;
import entity.Cart;
import entity.Form;
import entity.UserMst;
import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 *
 * @author 1
 */
@WebServlet(name = "userServlet", urlPatterns = {"/userServlet"})
public class userServlet extends HttpServlet {
    
    @EJB userLocal ul;

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
            out.println("<title>Servlet userServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 align='center'>User List</h1>");
            
            Collection<UserMst> users = ul.getAllUsers();
            out.println("<table border='1' align='center'>");
            out.println("<tr>");
            out.println("<th>UID</th>");
            out.println("<th>Username</th>");
            out.println("<th>Email</th>");
            out.println("<th>Password</th>");
            out.println("<th>Address</th>");
            out.println("<th>Role ID</th>");
            out.println("</tr>");
            
            for (UserMst user : users) {
                out.println("<tr>");
                out.println("<td>" + user.getUid() + "</td>");
                out.println("<td>" + user.getUname() + "</td>");
                out.println("<td>" + user.getEmail() + "<t/td>");
                out.println("<td>" + user.getPassword() + "</td>");
                out.println("<td>" + user.getAddress() + "</td>");
                out.println("<td>" + user.getRid() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            
//            ul.UserMst("aaa", "aaa@gmail.com","aaa", "Surat", 1);
//            ul.UserMst("bbb", "bbb@gmail.com","bbb", "Surat", 2);

//            ul.updateUserMst(3, "ccc", "ccc@gmail.com", "ccc","Navasari", 2);
//            ul.deleteUserMst(6, 2);

//            Cart
            out.println("<br>");
            out.println("<h1 align='center'>Cart</h1>");
            Collection<Cart> carts = ul.getAllCart();
            out.println("<table border='1' align='center'>");
            out.println("<tr>");
            out.println("<th>Cart ID</th>");
            out.println("<th>UID</th>");
            out.println("<th>Created_At</th>");
            out.println("<th>Updated_At</th>");
            out.println("<th>Status</th>");
            out.println("</tr>");
            
            for(Cart cart : carts){
                out.println("<tr>");
                out.println("<td>" + cart.getCartid() + "</td>");
                out.println("<td>" + cart.getUid() + "</td>");
                out.println("<td>" + cart.getCreatedAt() + "</td>");
                out.println("<td>" + cart.getUpdatedAt() + "</td>");
                out.println("<td>" + cart.getStatus() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            
//            Static LocalDateTime values for created_at and updated_at
            LocalDateTime createdAtLocal = LocalDateTime.of(2024, 11, 15, 20, 30, 0);
            LocalDateTime updatedAtLocal = LocalDateTime.of(2024, 11, 15, 15, 45, 0);

//            Convert LocalDateTime to Timestamp
            Timestamp created_at = Timestamp.valueOf(createdAtLocal);
            Timestamp updated_at = Timestamp.valueOf(updatedAtLocal);
            
//            ul.addCart(1, created_at, updated_at, "ordered");
//            ul.updateCart(2, 2, created_at, updated_at, "active");
//            ul.deleteCart(4, 1);

//            Form table
            out.println("<br>");
            out.println("<h1 align='center'>Form</h1>");
            Collection<Form> forms = ul.getAllForm();
            out.println("<table border='1' align='center'>");
            out.println("<tr>");
            out.println("<th>Form ID</th>");
            out.println("<th>UID</th>");
            out.println("<th>First Name</th>");
            out.println("<th>Mobile No</th>");
            out.println("<th>gender</th>");
            out.println("<th>DOB</th>");
            out.println("<th>Height</th>");
            out.println("<th>Weight</th>");
            out.println("<th>Address</th>");
            out.println("</tr>");
            
            for(Form form : forms){
                out.println("<tr>");
                out.println("<td>" + form.getFormId() + "</td>");
                out.println("<td>" + form.getUid() + "</td>");
                out.println("<td>" + form.getFname() + "</td>");
                out.println("<td>" + form.getMno() + "</td>");
                out.println("<td>" + form.getGender() + "</td>");
                out.println("<td>" + form.getDob() + "</td>");
                out.println("<td>" + form.getHeight() + "</td>");
                out.println("<td>" + form.getWeight() + "</td>");
                out.println("<td>" + form.getAddress() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            
//            long bigIntValue = 1234567890L;  // BIGINT value for mobile number
//            Date date = Date.valueOf("1990-05-15");  // Date of birth (DOB)
    
//  error          ul.addForm(1, "aaa", 1234567890L, "Male", date, 180, 75, "Mumbai");

//            out.println("<h1>Servlet userServlet at " + request.getContextPath() + "</h1>");
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
