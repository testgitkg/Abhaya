/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import ejb.adminLocal;
import entity.Admin;
import entity.Blog;
import entity.Brand;
import entity.Category;
import entity.Medicine;
import entity.Role;
import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Base64;
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
//            ad.addRole("Admin");
//            ad.addRole("User");
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

            
//            admin table
            out.println("<br>");            
//            ad.addAdmin("Khushi","khushi@gmail.com", "123", 1);
//            ad.updateAdmin(2, "Mitali", "mitali@gmail.com", "123", 1);
//            ad.deleteAdmin(3, 1);

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

            
//            Blog
            out.println("<br>");                              
//            Static LocalDateTime values for created_at and updated_at
            LocalDateTime createdAtLocal = LocalDateTime.of(2024, 11, 15, 14, 30, 0);
            LocalDateTime updatedAtLocal = LocalDateTime.of(2024, 11, 15, 15, 45, 0);

//            Convert LocalDateTime to Timestamp
            Timestamp created_at = Timestamp.valueOf(createdAtLocal);
            Timestamp updated_at = Timestamp.valueOf(updatedAtLocal);
//            ad.addBlog(1, "Happiness", "Happiness boosts health and longevity!!", "published", created_at, updated_at, "Health");            
//            ad.updateBlog(2, 1, "Sadness", "Sadness harms health, increasing stress levels!!", "published", created_at, updated_at, "Health");
//            ad.deleteBlog(3, 1);

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
        

//            brand

            out.println("<br>");
//            byte[] himalayaImg = Files.readAllBytes(Paths.get("E:\\Java EE\\abhaya\\src\\main\\webapp\\brand\\himalaya.png"));
//            ad.addBrand("Himalaya", himalayaImg, "Himalaya Wellness Company", "India", "https://www.himalayawellness.in");
//            byte[] daburImg = Files.readAllBytes(Paths.get("E:\\Java EE\\abhaya\\src\\main\\webapp\\brand\\dabur.png"));
//            ad.addBrand("Dabur", daburImg, "Dabur India Ltd", "India", "https://www.dabur.com");
            
//            byte[] soultreeImg = Files.readAllBytes(Paths.get("E:\\Java EE\\abhaya\\src\\main\\webapp\\brand\\soultree.png"));
//            ad.updateBrand(2, "Dabur", soultreeImg, "SoulTree", "India", " https://www.soultree.in");
            
//            ad.deleteBrand(3);
//            ad.deleteBrand(4);

            out.println("<h1 align='center'>Brands</h1>");
            Collection<Brand> brands = ad.getAllBrands(); // Assume this retrieves all Brand objects
            out.println("<table border='1' align='center'>");
            out.println("<tr>");
            out.println("<th>Brand ID</th>");
            out.println("<th>Brand Name</th>");
            out.println("<th>Image</th>");
            out.println("<th>Manufacturer</th>");
            out.println("<th>Country of Origin</th>");
            out.println("<th>Website URL</th>");
            out.println("</tr>");

            for (Brand brand : brands) {
                out.println("<tr>");
                out.println("<td>" + brand.getBid() + "</td>");
                out.println("<td>" + brand.getBname() + "</td>");

                // Display image as Base64 encoded string
                if (brand.getBimg() != null) {
                    String base64Image = Base64.getEncoder().encodeToString(brand.getBimg());
                    out.println("<td><img src='data:image/png;base64," + base64Image + "' width='150' height='110'></td>");
                } else {
                    out.println("<td>No Image</td>");
                }

                out.println("<td>" + brand.getManufacturer() + "</td>");
                out.println("<td>" + brand.getCountryOrigin() + "</td>");
                out.println("<td><a href='" + brand.getSiteUrl() + "' target='_blank'>" + brand.getSiteUrl() + "</a></td>");
                out.println("</tr>");
            }
            out.println("</table>");

//            category 
            out.println("<br>");            
//            ad.addCategory("Repository-Care", "Comprehensive solutions for health and wellness.");
//            ad.updateCategory(2, "Skin-Care", "Enhancing skin health and radiance naturally.");
//            ad.updateCategory(5, "Baby-Care", "Nurturing care for your baby's health.");
//            ad.deleteCategory(3);

            out.println("<h1 align='center'>Categories</h1>");
            Collection<Category> categories = ad.getAllCategories();  // Assume this retrieves all Category objects
            out.println("<table border='1' align='center'>");
            out.println("<tr>");
            out.println("<th>Category ID</th>");
            out.println("<th>Category Name</th>");
            out.println("<th>Description</th>");
            out.println("</tr>");

            for (Category category : categories) {
                out.println("<tr>");
                out.println("<td>" + category.getCatId() + "</td>");
                out.println("<td>" + category.getCname() + "</td>");
                out.println("<td>" + category.getDescription() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");

//            medicine
            out.println("<br>");
            out.println("<h1 align='center'>Medicines</h1>");

            // Add a new Medicine
            byte[] antisepticImg = Files.readAllBytes(Paths.get("E:\\Java EE\\abhaya\\src\\main\\webapp\\cat_imgs\\antiseptic.png"));
            ad.addMedicine("Antiseptic", antisepticImg, "Prevents infection and heals wounds", 150, "100ml", "Available", 1, 2); // Example data
         
//            byte[] updatedMedicineImg = Files.readAllBytes(Paths.get("E:\\Java EE\\abhaya\\src\\main\\webapp\\medicine\\updated_medicine.png"));
//            ad.updateMedicine(1, "Updated Medicine", updatedMedicineImg, "Updated description", 300, "200ml", "Out of Stock", 1, 2);
            
//            ad.deleteMedicine(2, 1, 2); // Deletes the medicine with mid=2, bid=1, cat_id=2

            // Display Medicines in a Table
            Collection<Medicine> medicines = ad.getAllMedicines(); // Assume this retrieves all Medicine objects
            out.println("<table border='1' align='center'>");
            out.println("<tr>");
            out.println("<th>Medicine ID</th>");
            out.println("<th>Medicine Name</th>");
            out.println("<th>Image</th>");
            out.println("<th>Description</th>");
            out.println("<th>Price</th>");
            out.println("<th>Quantity</th>");
            out.println("<th>Availability</th>");
            out.println("<th>Brand ID</th>");
            out.println("<th>Category ID</th>");
            out.println("</tr>");

            for (Medicine medicine : medicines) {
                out.println("<tr>");
                out.println("<td>" + medicine.getMid() + "</td>");
                out.println("<td>" + medicine.getMname() + "</td>");

                // Display image as Base64 encoded string
//                if (medicine.getImg() != null) {
//                    String base64Image = Base64.getEncoder().encodeToString(medicine.getImg());
//                    out.println("<td><img src='data:cat_imgs/png;base64," + base64Image + "' width='100' height='130'></td>");
//                } else {
//                    out.println("<td>No Image</td>");
//                }

                out.println("<td>" + medicine.getDescription() + "</td>");
                out.println("<td>" + medicine.getPrice() + "</td>");
                out.println("<td>" + medicine.getQuantity() + "</td>");
                out.println("<td>" + medicine.getAvailability() + "</td>");
                out.println("<td>" + medicine.getBid() + "</td>");
                out.println("<td>" + medicine.getCatId() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");

            
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
