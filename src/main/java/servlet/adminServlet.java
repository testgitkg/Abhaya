/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import ejb.adminLocal;
import entity.Admin;
import entity.Blog;
import entity.Role;
import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 *
 * @author 1
 */
@WebServlet(name = "adminServlet", urlPatterns = {"/adminServlet"})
public class adminServlet extends HttpServlet {
    
    @EJB adminLocal ad;

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
            out.println("<title>Servlet adminServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
//            role's tab;e
            out.println("<h1 align='center'>Roles</h1>");
            Collection<Role> roles = ad.getAllRoles();
            out.println("<table border='1' align='center'>");
            out.println("<tr>");
            out.println("<th>RID</th>");
            out.println("<th>Role Name</th>");
            out.println("</tr>");
            
            for(Role role : roles){
                out.println("<tr>");
                out.println("<td>" + role.getRid() + "</td>");
                out.println("<td>" + role.getRoleName() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
//            ad.addRole("Admin");
//            ad.addRole("User");
            
//            admin table
            out.println("<br>");
            out.println("<h1 align='center'>Admin</h1>");
            Collection<Admin> admins = ad.getAllAdmin();
            out.println("<table border='1' align='center'>");
            out.println("<tr>");
            out.println("<th>AID</th>");
            out.println("<th>Name</th>");
            out.println("<th>Email</th>");
            out.println("<th>Password</th>");
            out.println("<th>RID</th>");
            out.println("</tr>");
            
            for(Admin admin : admins){
                out.println("<tr>");
                out.println("<td>" + admin.getAid() + "</td>");
                out.println("<td>" + admin.getAname() + "</td>");
                out.println("<td>" + admin.getEmail() + "</td>");
                out.println("<td>" + admin.getPassword() + "</td>");
                out.println("<td>" + admin.getRid() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");

//            ad.addAdmin("Khushi","khushi@gmail.com", "123", 1);
//            ad.updateAdmin(2, "Mitali", "mitali@gmail.com", "123", 1);
//            ad.deleteAdmin(3, 1);
            
//            Blog
            out.println("<br>");
            out.println("<h1 align='center'>Blogs</h1>");
            Collection<Blog> blogs = ad.getAllBlog();
            out.println("<table border='1' align='center'>");
            out.println("<tr>");
            out.println("<th>Blog ID</th>");
            out.println("<th>AID</th>");
            out.println("<th>Title</th>");
            out.println("<th>Content</th>");
            out.println("<th>Status</th>");
            out.println("<th>Created_At</th>");
            out.println("<th>Updated_At</th>");
            out.println("<th>Tags</th>");
            out.println("</tr>");
            
            for(Blog blog : blogs){
                out.println("<tr>");
                out.println("<td>" + blog.getBlogId() + "</td>");
                out.println("<td>" + blog.getAid() + "</td>");
                out.println("<td>" + blog.getTitle() + "</td>");
                out.println("<td>" + blog.getContent() + "</td>");
                out.println("<td>" + blog.getStatus() + "</td>");
                out.println("<td>" + blog.getCreatedAt() + "</td>");
                out.println("<td>" + blog.getUpdatedAt() + "</td>");
                out.println("<td>" + blog.getTags() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            
//            Static LocalDateTime values for created_at and updated_at
            LocalDateTime createdAtLocal = LocalDateTime.of(2024, 11, 15, 14, 30, 0);
            LocalDateTime updatedAtLocal = LocalDateTime.of(2024, 11, 15, 15, 45, 0);

//            Convert LocalDateTime to Timestamp
            Timestamp created_at = Timestamp.valueOf(createdAtLocal);
            Timestamp updated_at = Timestamp.valueOf(updatedAtLocal);
//            ad.addBlog(1, "Happiness", "Happiness boosts health and longevity!!", "published", created_at, updated_at, "Health");
            
//            ad.updateBlog(2, 1, "Sadness", "Sadness harms health, increasing stress levels!!", "published", created_at, updated_at, "Health");
//            ad.deleteBlog(3, 1);
        
//            out.println("<h1>Servlet adminServlet at " + request.getContextPath() + "</h1>");
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
