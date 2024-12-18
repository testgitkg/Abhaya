/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import client.adminClient;
import ejb.adminLocal;
import entity.Admin;
import entity.Blog;
import entity.Brand;
import entity.CartItem;
import entity.Category;
import entity.Feedback;
import entity.Form;
import entity.InventoryManage;
import entity.Medicine;
import entity.Order1;
import entity.OrderManage;
import entity.Role;
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
import java.util.Collection;

/**
 *
 * @author abhaya
 */
@WebServlet(name = "adminServlet", urlPatterns = {"/adminServlet"})
public class adminServlet extends HttpServlet {
    
    @EJB adminLocal ad;
    adminClient ac;

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
            
//            role's table
            out.print("<div align='center'>");
            out.println("<h1>Roles</h1>");
            Collection<Role> roles = ad.getAllRoles();           
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>RID</th>");
            out.println("<th>Role Name</th>");
            out.println("</tr>");            
            
//            List<Integer> sids = new ArrayList<Integer>();
//            sids.add(1); sids.add(2); sids.add(3);
            
            for(Role role : roles){
                out.println("<tr>");
                out.println("<td>" + role.getRid() + "</td>");
                out.println("<td>" + role.getRoleName() + "</td>");
                out.println("</tr>");
            }           
            out.println("</table>");
            
            Collection<Role> getrid = ad.getRoleById(2);
            for(Role r : getrid){
                out.println("<br>" + "RID :" + r.getRid() + " Role Name :" + r.getRoleName());                        
            }
            
            Collection<Role> getrolebyname =ad.getRoleByName("Admin");
            for(Role rn : getrolebyname){
                out.println("<br>" + "RID :" + rn.getRid() + " Role Name :" + rn.getRoleName());
            }
            out.print("</div>");
            
            
            
//            ad.addRole("Admin");
//            ad.addRole("User");
//            ad.updateRole(3, "Manager");
//            ad.deleteRole(4);

           
//            admin table
            out.println("<br>");
            out.print("<div align='center'>");
            out.println("<h1>Admin</h1>");
            Collection<Admin> admins = ad.getAllAdmin();
            out.println("<table border='1'>");
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
            
            Collection<Admin> getaid = ad.getAdminById(1);
            for(Admin a : getaid){
                out.println("<br>" + "AID :" + a.getAid() + " Admin Name :" + a.getAname() + " Email :" + a.getEmail() + " Password :" + a.getPassword() + " RID :" + a.getRid());
            }
            
            Collection<Admin> getaname = ad.getAdminbyName("Mitali");
            for(Admin an : getaname){
                out.println("<br>" + "AID :" + an.getAid() + " Admin Name :" + an.getAname() + " Email :"+ an.getEmail() + " Password :" + an.getPassword() + " RID :" + an.getRid());
            }
            out.print("</div>");
            
//            ad.addAdmin("Khushi","khushi@gmail.com", "123", 1);
//            ad.updateAdmin(2, "Mitali", "mitali@gmail.com", "123", 1);
//            ad.deleteAdmin(3, 1);

            
//            Blog
            out.println("<br>");
            out.print("<div align='center'>");
            out.println("<h1>Blogs</h1>");
            Collection<Blog> blogs = ad.getAllBlog();
            out.println("<table border='1'>");
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
            
            Collection<Blog> getbid = ad.getBlogByid(1);
            for(Blog b : getbid){
                out.println("<br>" + "Blog_id: " + b.getAid() + " AID :" + b.getAid() + " Title :" + 
                        b.getTitle() + " Content :" + b.getContent() + " Status :" + b.getStatus() + 
                        " Created_at :" + b.getCreatedAt() + " Updated_at :" + b.getUpdatedAt() + " Tags :" + b.getTags());
            }
            
            Collection<Blog> gettitle = ad.getBlogByTitle("Sadness");
            for(Blog bt : gettitle){
                out.println("<br>" + "Blog_id: " + bt.getAid() + " AID :" + bt.getAid() + " Title :" + 
                        bt.getTitle() + " Content :" + bt.getContent() + " Status :" + bt.getStatus() + 
                        " Created_at :" + bt.getCreatedAt() + " Updated_at :" + bt.getUpdatedAt() + " Tags :" + bt.getTags());
            }
            
            Collection<Blog> gettags = ad.getBlogByTag("Health");
            for(Blog ta : gettags){
                out.println("<br>" + "Blog_id: " + ta.getAid() + " AID :" + ta.getAid() + " Title :" + 
                        ta.getTitle() + " Content :" + ta.getContent() + " Status :" + ta.getStatus() + 
                        " Created_at :" + ta.getCreatedAt() + " Updated_at :" + ta.getUpdatedAt() + " Tags :" + ta.getTags());
            }
            out.print("</div>");
            
            
//           Timestamp created_at = Timestamp.valueOf(LocalDateTime.of(2024, 11, 15, 14, 30, 0));
//            Timestamp updated_at = Timestamp.valueOf(LocalDateTime.of(2024, 11, 15, 15, 45, 0));
//            ad.addBlog(1, "Happiness", "Happiness boosts health and longevity!!", "published", "Health");            
//            ad.updateBlog(4, 1, "Sadness", "Sadness harms health, increasing stress levels!!", "published", "Health");
//            ad.deleteBlog(3, 1);
        

//            brand
            out.println("<br>");
            out.print("<div align='center'>");
            out.println("<h1>Brands</h1>");
            Collection<Brand> brands = ad.getAllBrands(); // Assume this retrieves all Brand objects
            out.println("<table border='1'>");
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
                out.println("<td>" + brand.getBimg()+ "</td>");
//                if (brand.getBimg() != null) {
//                    String base64Image = Base64.getEncoder().encodeToString(brand.getBimg());
//                    out.println("<td><img src='data:image/png;base64," + base64Image + "' width='150' height='110'></td>");
//                } else {
//                    out.println("<td>No Image</td>");
//                }

                out.println("<td>" + brand.getManufacturer() + "</td>");
                out.println("<td>" + brand.getCountryOrigin() + "</td>");
                out.println("<td><a href='" + brand.getSiteUrl() + "' target='_blank'>" + brand.getSiteUrl() + "</a></td>");
                out.println("</tr>");
            }
            out.println("</table>");
            
            Collection<Brand> getbname = ad.getBrandByBname("Dabur");
            for(Brand b : getbname){
                out.println("<br>" + "Brand id :" + b.getBid() + " Brand Name :" + b.getBname() +
                        " Image :" + b.getBimg() + " Manufacturer :" + b.getManufacturer() + 
                        " Country_origin :" + b.getCountryOrigin() + " Site_URL :" + b.getSiteUrl());
            }
            out.print("</div>");
            
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
            out.print("<div align='center'>");
            out.println("<h1>Categories</h1>");
            Collection<Category> categories = ad.getAllCategories();  // Assume this retrieves all Category objects
            out.println("<table border='1'>");
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
            
            Collection<Category> getcname = ad.getCategoryByCname("Repository-Care");
            for(Category c : getcname){
                out.println("<br>" + "Category id :" + c.getCatId() + " Category Name :" + c.getCname() + 
                        " Description :" + c.getDescription());
            }
            out.print("</div>");

            
//            ad.addCategory("Repository-Care", "Comprehensive solutions for health and wellness.");
//            ad.updateCategory(2, "Skin-Care", "Enhancing skin health and radiance naturally.");
//            ad.updateCategory(5, "Baby-Care", "Nurturing care for your baby's health.");
//            ad.deleteCategory(3);

//            medicine
            out.println("<br>");
            out.print("<div align='center'>");
            out.println("<h1>Medicines</h1>");
            Collection<Medicine> medicines = ad.getAllMedicines(); // Assume this retrieves all Medicine objects
            out.println("<table border='1'>");
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
                out.println("<td>" + medicine.getImg()+ "</td>");

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
            
            Collection<Medicine> getmedicine = ad.getMedicineByMname("Asthma");
            for(Medicine m : getmedicine){
                out.println("<br>" + "MID :" + m.getMid() + " Medicine Name :" + m.getMname() + 
                        " Image :" + m.getImg() + " Description :" + m.getDescription() + 
                        " Price :" + m.getPrice() + " Quantity :" + m.getQuantity() + 
                        " Availability :" + m.getAvailability() + " BID :" + m.getBid() + 
                        " Category id :" + m.getCatId());
            }
            
            Collection<Medicine> getavailability = ad.getMediByAvailability("Available");
            for(Medicine ma : getavailability){
                out.println("<br>" + "MID :" + ma.getMid() + " Medicine Name :" + ma.getMname() + 
                        " Image :" + ma.getImg() + " Description :" + ma.getDescription() + 
                        " Price :" + ma.getPrice() + " Quantity :" + ma.getQuantity() + 
                        " Availability :" + ma.getAvailability() + " BID :" + ma.getBid() + 
                        " Category id :" + ma.getCatId());
            }
            out.print("</div>");
            
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
                out.print("<div align='center'>");
                out.println("<h1>Cart Items</h1>");
                Collection<CartItem> cartItems = ad.getAllCartItems();
                out.println("<table border='1'>");
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
                out.print("</div>");
                
            BigDecimal price = new BigDecimal("250");         
//            ad.addCartItem(2, 1, 2, price);            
//            ad.addCartItem(1, 2, 1, price);
//            ad.addCartItem(2, 1, 3, price);

//            ad.updateCartItem(3, 2, 1, 2, price);
//            ad.deleteCartItem(1, 2, 1);

//            order manage
            out.println("<br>");
            out.print("<div align='center'>");
            out.println("<h1>Order Management</h1>");
            Collection<OrderManage> orderManagements = ad.getAllOrderManages(); // Assume this retrieves all OrderManage objects
            out.println("<table border='1'>");
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
            
            Collection<OrderManage> getstatus = ad.getStatus("shipped");
            for(OrderManage om : getstatus){
                out.println("<br>" + "Manage id :" + om.getManageId() + " Orded id :" + om.getOid() + 
                        " Status :" + om.getStatus() + " Timestamp :" + om.getTimestamp());
            }
            out.print("</div>");
           
//            Timestamp timestamp = Timestamp.valueOf(LocalDateTime.of(2024, 9, 5, 9, 20));
//            ad.addOrderManage(1, "processing");
//            ad.addOrderManage(1, "Processing", new Timestamp(System.currentTimeMillis()));
//            ad.addOrderManage(2, "shipped", Timestamp.valueOf("2024-11-16 10:00:00"));
//            ad.updateOrderManage(11, 1, "shipped");
//            ad.deleteOrderManage(5, 1);

//            inventory manage
            out.println("<br>");
            out.print("<div align='center'>");
            out.println("<h1>Inventory Manage</h1>");
            Collection<InventoryManage> inventories = ad.getAllInventories();
            out.println("<table border='1'>");
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
            
            Collection<InventoryManage> getinvstatus = ad.getInventoryByAction("add");
            for(InventoryManage im : getinvstatus){
                out.println("<br>" + "Inventory id :" + im.getInventoryId() + " MID :" + im.getMid() + 
                        " Quantity :" + im.getQuantity() + " Action :" + im.getAction() + 
                        " Action Date :" + im.getActionDate() + " Managed by :" + im.getManagedBy() + 
                        " Notes :" + im.getNotes());
            }
            out.print("</div>");
            
//            ad.addInventory(6, 3, "add", 2, "Item Added");
//            ad.addInventory(2, 10, "remove", 1, "Removed stock.");
            
//            ad.updateInventory(2, 1, 20, "Removed Stock", 1, "Adjusted due to damaged items.");
//            ad.deleteInventory(3, 3);


//            user data

            out.println("<br>");
            out.print("<div align='center'>");
            out.println("<h1>User Data</h1>");            
            Collection<UserMst> users = ad.getAllUsers();
            out.println("<table border='1'>");
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
            
            Collection<UserMst> getuname = ad.getUserByUname("aaa");
            for(UserMst u : getuname){
                out.println("<br>" + "UID :" + u.getUid() + " Uname :" + u.getUname() + 
                        " Email :" + u.getEmail() + " Password :" + u.getPassword() +
                        " Address :" + u.getAddress() + " RID :" + u.getRid());
            }
            
            Collection<UserMst> getemail = ad.getUserByEmail("ccc@gmail.com");
            for(UserMst ue : getemail){
                out.println("<br>" + "UID :" + ue.getUid() + " Uname :" + ue.getUname() + 
                        " Email :" + ue.getEmail() + " Password :" + ue.getPassword() +
                        " Address :" + ue.getAddress() + " RID :" + ue.getRid());
            }
            out.print("</div>");
            
//            Form table

            out.println("<br>");
            out.print("<div align='center'>");
            out.println("<h1>Form</h1>");
            Collection<Form> forms = ad.getAllForm();
            out.println("<table border='1'>");
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
            
            Collection<Form> getformid = ad.getFormByFormId(1);
            for(Form f : getformid){
                out.println("<br>" + "FID :" + f.getFormId() + " UID :" + f.getUid() + 
                        " Fname :" + f.getFname()+ " Mno :" + f.getMno() + 
                        " Gender :" + f.getGender() + " DOB :" + f.getDob() + 
                        " Height :" + f.getHeight() + " Weight :" + f.getWeight() + 
                        " Address :" + f.getAddress());
            }
            
            Collection<Form> getfname = ad.getFormByFname("bbb");
            for(Form fn : getfname){
                out.println("<br>" + "FID :" + fn.getFormId() + " UID :" + fn.getUid() + 
                        " Fname :" + fn.getFname()+ " Mno :" + fn.getMno() + 
                        " Gender :" + fn.getGender() + " DOB :" + fn.getDob() + 
                        " Height :" + fn.getHeight() + " Weight :" + fn.getWeight() + 
                        " Address :" + fn.getAddress());
            }
            out.print("</div>");

            
//            feedback table of user         
            out.println("<br>");
            out.print("<div align='center'>");
            out.println("<h1>Feedback</h1>");
            Collection<Feedback> feedbacks = ad.getAllFeedback();
            out.println("<table border='1'>");
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
            
            Collection<Feedback> getfid = ad.getFeedbackByFid(2);
            for(Feedback f : getfid){
                out.println("<br>" + "FID :" + f.getFid() + " UID :" + f.getUid() + 
                        " Rating :" + f.getRating() + " Comments :" + f.getComments() +
                        " Feedback date :" + f.getFeedbackDate());
            }
            out.print("</div>");
            
//            order by user table
            out.println("<br>");
            out.print("<div align='center'>");
            out.println("<h1>Orders</h1>");
            Collection<Order1> orders = ad.getAllOrders();
            out.println("<table border='1'>");
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
            
            Collection<Order1> getoid = ad.getOrderByOid(1);
            for(Order1 o : getoid){
                out.println("<br>" + "OID :" + o.getOid() + " UID :" + o.getUid() + 
                        " Order date :" + o.getOrderDate() + " Status :" + o.getStatus() + 
                        " Totsl Amount :" + o.getTotalAmt() + " Shipping Add :" + o.getShippingAdd() + 
                        " Payment status :" + o.getPaymentStatus()+
                        " Payment method :" + o.getPaymentMethod());
            }
            out.print("</div>");
            
            ac.addRole("kuuahiREST");
            

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
