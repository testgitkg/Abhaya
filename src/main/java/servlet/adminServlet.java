/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import ejb.adminLocal;
import entity.Admin;
import entity.Blog;
import entity.Brand;
import entity.CartItem;
import entity.Category;
import entity.InventoryManage;
import entity.Medicine;
import entity.OrderManage;
import entity.Role;
import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
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
//            ad.updateRole(3, "Manager");
//            ad.deleteRole(4);
        

            
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
            
            
           Timestamp created_at = Timestamp.valueOf(LocalDateTime.of(2024, 11, 15, 14, 30, 0));
            Timestamp updated_at = Timestamp.valueOf(LocalDateTime.of(2024, 11, 15, 15, 45, 0));
//            ad.addBlog(1, "Happiness", "Happiness boosts health and longevity!!", "published", created_at, updated_at, "Health");            
//            ad.updateBlog(2, 1, "Sadness", "Sadness harms health, increasing stress levels!!", "published", created_at, updated_at, "Health");
//            ad.deleteBlog(3, 1);
        

//            brand
            out.println("<br>");
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
            
//            byte[] himalayaImg = Files.readAllBytes(Paths.get("E:\\Java EE\\abhaya\\src\\main\\webapp\\brand\\himalaya.png"));
//            ad.addBrand("Himalaya", himalayaImg, "Himalaya Wellness Company", "India", "https://www.himalayawellness.in");
//            byte[] daburImg = Files.readAllBytes(Paths.get("E:\\Java EE\\abhaya\\src\\main\\webapp\\brand\\dabur.png"));
//            ad.addBrand("Dabur", daburImg, "Dabur India Ltd", "India", "https://www.dabur.com");
            
//            byte[] soultreeImg = Files.readAllBytes(Paths.get("E:\\Java EE\\abhaya\\src\\main\\webapp\\brand\\soultree.png"));
//            ad.updateBrand(2, "Dabur", soultreeImg, "SoulTree", "India", " https://www.soultree.in");
            
//            ad.deleteBrand(3);
//            ad.deleteBrand(4);


//            category 
            out.println("<br>");
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
            
//            ad.addCategory("Repository-Care", "Comprehensive solutions for health and wellness.");
//            ad.updateCategory(2, "Skin-Care", "Enhancing skin health and radiance naturally.");
//            ad.updateCategory(5, "Baby-Care", "Nurturing care for your baby's health.");
//            ad.deleteCategory(3);

//            medicine
            out.println("<br>");
            out.println("<h1 align='center'>Medicines</h1>");
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
                if (medicine.getImg() != null) {
                    String base64Image = Base64.getEncoder().encodeToString(medicine.getImg());
                    out.println("<td><img src='data:cat_imgs/png;base64," + base64Image + "' width='100' height='130'></td>");
                } else {
                    out.println("<td>No Image</td>");
                }

                out.println("<td>" + medicine.getDescription() + "</td>");
                out.println("<td>" + medicine.getPrice() + "</td>");
                out.println("<td>" + medicine.getQuantity() + "</td>");
                out.println("<td>" + medicine.getAvailability() + "</td>");
                out.println("<td>" + medicine.getBid() + "</td>");
                out.println("<td>" + medicine.getCatId() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            
//                        try {                
//                byte[] antisepticImg = Files.readAllBytes(Paths.get("E:\\Java EE\\abhaya\\src\\main\\webapp\\medicine\\antiseptic.png"));
//                ad.addMedicine("Antiseptic", antisepticImg, "Prevents infection and heals wounds", 150, "100ml", "Available", 1, 2);

//                byte[] anxietyImg = Files.readAllBytes(Paths.get("E:\\Java EE\\abhaya\\src\\main\\webapp\\medicine\\anxiety.png"));
//                ad.updateMedicine(2, "Anxiety", anxietyImg, "Relieves stress and anxiety", 500, "60 tablets", "Out of Stock", 1, 2);

            //    ad.deleteMedicine(2, 1, 2);
//            } catch (IOException e) {
//                out.println("<p>Error reading image file: " + e.getMessage() + "</p>");
//                e.printStackTrace();
//            } catch (Exception e) {
//                out.println("<p>Error while performing database operations: " + e.getMessage() + "</p>");
//                e.printStackTrace();
//            }


//            cart item
                out.println("<br>");
                out.println("<h1 align='center'>Cart Items</h1>");
                Collection<CartItem> cartItems = ad.getAllCartItems();
                out.println("<table border='1' align='center'>");
                out.println("<tr>");
                out.println("<th>Cart Item ID</th>");
                out.println("<th>Cart ID</th>");
                out.println("<th>Medicine ID</th>");
                out.println("<th>Quantity</th>");
                out.println("<th>Price</th>");
                out.println("<th>Actions</th>");
                out.println("</tr>");

                for (CartItem cartItem : cartItems) {
                    out.println("<tr>");
                    out.println("<td>" + cartItem.getCartItemId() + "</td>");
                    out.println("<td>" + cartItem.getCartid() + "</td>");
                    out.println("<td>" + cartItem.getMid() + "</td>");
                    out.println("<td>" + cartItem.getQuantity() + "</td>");
                    out.println("<td>" + cartItem.getPrice() + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
                
            BigDecimal price = new BigDecimal("190");         
//            ad.addCartItem(2, 1, 2, price);            
//            ad.addCartItem(1, 2, 1, price);
//            ad.addCartItem(2, 1, 3, price);

//            ad.updateCartItem(2, 2, 1, 2, price);
//            ad.deleteCartItem(1, 2, 1);

//            order manage
            out.println("<br>");
            out.println("<h1 align='center'>Order Management</h1>");
            Collection<OrderManage> orderManagements = ad.getAllOrderManages(); // Assume this retrieves all OrderManage objects
            out.println("<table border='1' align='center'>");
            out.println("<tr>");
            out.println("<th>Manage ID</th>");
            out.println("<th>Order ID</th>");
            out.println("<th>Status</th>");
            out.println("<th>Timestamp</th>");
            out.println("</tr>");

            for (OrderManage orderManage : orderManagements) {
                out.println("<tr>");
                out.println("<td>" + orderManage.getManageId() + "</td>");
                out.println("<td>" + orderManage.getOid() + "</td>");
                out.println("<td>" + orderManage.getStatus() + "</td>");
                out.println("<td>" + orderManage.getTimestamp() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
           
//            Timestamp timestamp = Timestamp.valueOf(LocalDateTime.of(2024, 9, 5, 9, 20));
//            ad.addOrderManage(1, "processing", timestamp);
//            ad.addOrderManage(1, "Processing", new Timestamp(System.currentTimeMillis()));
//            ad.addOrderManage(2, "shipped", Timestamp.valueOf("2024-11-16 10:00:00"));
//            ad.updateOrderManage(2, 1, "shipped", timestamp);
//            ad.deleteOrderManage(5, 1);

//            inventory manage
            out.println("<br>");
            out.println("<h1 align='center'>Inventory Manage</h1>");
            Collection<InventoryManage> inventories = ad.getAllInventories();
            out.println("<table border='1' align='center'>");
            out.println("<tr>");
            out.println("<th>Inventory ID</th>");
            out.println("<th>Medicine ID</th>");
            out.println("<th>Quantity</th>");
            out.println("<th>Action</th>");
            out.println("<th>Action Date</th>");
            out.println("<th>Managed By</th>");
            out.println("<th>Notes</th>");
            out.println("</tr>");

            for (InventoryManage inventory : inventories) {
                out.println("<tr>");
                out.println("<td>" + inventory.getInventoryId() + "</td>");
                out.println("<td>" + inventory.getMid() + "</td>");
                out.println("<td>" + inventory.getQuantity() + "</td>");
                out.println("<td>" + inventory.getAction() + "</td>");
                out.println("<td>" + inventory.getActionDate() + "</td>");
                out.println("<td>" + inventory.getManagedBy() + "</td>");
                out.println("<td>" + inventory.getNotes() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            
//            ad.addInventory(1, 7, "add", Timestamp.valueOf("2024-11-16 10:00:00"), 1, "Restocked with new supply");
//            ad.addInventory(2, 10, "remove", Timestamp.valueOf("2024-11-16 10:00:00"), 1, "Removed stock.");
            
//            ad.updateInventory(2, 1, 20, "Removed Stock", Timestamp.valueOf("2024-11-16 12:00:00"), 1, "Adjusted due to damaged items.");
//            ad.deleteInventory(3, 3);
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
