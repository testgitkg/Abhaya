/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import ejb.userLocal;
import entity.Cart;
import entity.Feedback;
import entity.Form;
import entity.Order1;
import entity.OrderItem;
import entity.UserMst;
import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.math.BigInteger;
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
            
//            user master
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
            
            
//            LocalDateTime createdAtLocal = LocalDateTime.of(2024, 11, 15, 20, 30, 0);
//            LocalDateTime updatedAtLocal = LocalDateTime.of(2024, 11, 15, 15, 45, 0);
            Timestamp created_at = Timestamp.valueOf(LocalDateTime.of(2024, 11, 9, 20, 30, 0));
            Timestamp updated_at = Timestamp.valueOf(LocalDateTime.of(2024, 11, 14, 15, 45, 0));
            
//            ul.addCart(1, created_at, updated_at, "ordered");
//            ul.addCart(3, created_at, updated_at, "ordered");
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
           
//            ul.addForm(1, "aaa", new BigInteger("6352778198");, "Male", Date.valueOf("1990-05-15"), 180, 75, "Mumbai");
//            ul.updateForm(3, 4, "bbb", new BigInteger("6352778198");, "Male", Date.valueOf("1990-05-15");, 150, 50, "Godhara");
//            ul.updateForm(3, 4, "bbb", new BigInteger("6352778198");, "Male", Date.valueOf("1990-05-15");, 150, 50, "Godhara");
//            ul.deleteForm(4, 1);            


//            feedback table            
            out.println("<br>");
            out.println("<h1 align='center'>Feedback</h1>");
            Collection<Feedback> feedbacks = ul.getAllFeedback();
            out.println("<table border='1' align='center'>");
            out.println("<tr>");
            out.println("<th>Feedback ID</th>");
            out.println("<th>UID</th>");
            out.println("<th>Rating</th>");
            out.println("<th>Comments</th>");
            out.println("<th>Feedback Date</th>");
            out.println("</tr>");

            for (Feedback feedback : feedbacks) {
                out.println("<tr>");
                out.println("<td>" + feedback.getFid() + "</td>");
                out.println("<td>" + feedback.getUid() + "</td>");
                out.println("<td>" + feedback.getRating() + "</td>");
                out.println("<td>" + feedback.getComments() + "</td>");
                out.println("<td>" + feedback.getFeedbackDate() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");

//            ul.addFeddback(1, 4, "It is very good website!!", updated_at);
//            ul.addFeddback(2, 5, "fantabulous!!", updated_at);
//            ul.addFeddback(1, 4, "It is very good website!!", updated_at);
//            ul.updateFeedback(3, 3, 2, "good", updated_at);
//            ul.deleteFeedback(4, 1);
//            ul.deleteFeedback(5, 2);
//            ul.deleteFeedback(6, 1);


//            order table
            out.println("<br>");
            out.println("<h1 align='center'>Orders</h1>");
            Collection<Order1> orders = ul.getAllOrders();
            out.println("<table border='1' align='center'>");
            out.println("<tr>");
            out.println("<th>Order ID</th>");
            out.println("<th>UID</th>");
            out.println("<th>Order Date</th>");
            out.println("<th>Status</th>");
            out.println("<th>Total Amount</th>");
            out.println("<th>Shipping Address</th>");
            out.println("<th>Payment Status</th>");
            out.println("<th>Payment Method</th>");
            out.println("</tr>");

            for(Order1 order : orders){
                out.println("<tr>");
                out.println("<td>" + order.getOid() + "</td>");
                out.println("<td>" + order.getUid()+ "</td>");
                out.println("<td>" + order.getOrderDate() + "</td>");
                out.println("<td>" + order.getStatus() + "</td>");
                out.println("<td>" + order.getTotalAmt() + "</td>");
                out.println("<td>" + order.getShippingAdd() + "</td>");
                out.println("<td>" + order.getPaymentStatus() + "</td>");
                out.println("<td>" + order.getPaymentMethod() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");

//            ul.addOrder(1, updated_at, "pending", new BigDecimal("200"), "Piplod,Surat", "unpaid", "COD");
//            ul.addOrder(2, updated_at, "shipped", new BigDecimal("150"), "Varachha,Surat", "paid", "UPI");
//            ul.updateOrder(2, 1, updated_at, "shipped", new BigDecimal("300"), "Varachha,Surat", "paid", "UPI");
//            ul.deleteOrder(3, 2);
//            ul.deleteOrder(4, 1);
//            ul.deleteOrder(5, 2);

//            order item

            out.println("<br>");
            out.println("<h1 align='center'>Order Items</h1>");
            Collection<OrderItem> orderItems = ul.getAllOrderItems(); // Assume this retrieves all OrderItem objects
            out.println("<table border='1' align='center'>");
            out.println("<tr>");
            out.println("<th>Order Item ID</th>");
            out.println("<th>Order ID</th>");
            out.println("<th>Medicine ID</th>");
            out.println("<th>Quantity</th>");
            out.println("<th>Price</th>");
            out.println("<th>Total Amount</th>");
            out.println("</tr>");

            for (OrderItem orderItem : orderItems) {
                out.println("<tr>");
                out.println("<td>" + orderItem.getOrderItemId() + "</td>");
                out.println("<td>" + orderItem.getOid() + "</td>");
                out.println("<td>" + orderItem.getMid() + "</td>");
                out.println("<td>" + orderItem.getQuantity() + "</td>");
                out.println("<td>" + orderItem.getPrice() + "</td>");
                out.println("<td>" + orderItem.getTotalAmt() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            
//            ul.addOrderItem(1, 2, 10, new BigDecimal("150"), new BigDecimal("1500.00"));
//            ul.addOrderItem(2, 1, 5, new BigDecimal("200"), new BigDecimal("1000.00"));
            
//            ul.updateOrderItem(3, 1, 1, 20, new BigDecimal("120"), new BigDecimal("2400.00"));
//            ul.deleteOrderItem(4, 2, 1);
//            ul.deleteOrderItem(5, 1, 2);
//            ul.deleteOrderItem(6, 2, 1);





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
