/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package REST;

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
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.Collection;

/**
 * REST Web Service
 *
 * @author abhaya
 */
@Path("Admin")
@RequestScoped
public class AdminResource {

   @EJB adminLocal al;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AdminResource
     */
    public AdminResource() {
    }

    /**
     * Retrieves representation of an instance of REST.AdminResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of AdminResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
//    role
    
    @POST
    @Path("/addrole/{roleName}")
    public void addRole(@PathParam("roleName")String role_name) {
        al.addRole(role_name);
    }
    
    @PUT
    @Path("/updaterole/{rid}/{roleName}")
    public void updateRole(@PathParam("rid")Integer rid, @PathParam("roleName")String role_name) {
        al.updateRole(rid, role_name);
    }
    
    @DELETE
     @Path("/deleterole/{rid}")
     public void deleteRole(@PathParam("rid")Integer rid) {
         al.deleteRole(rid);
     } 
     
    @GET
    @Path("/allroles")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Role> getAllRoles() {
        return al.getAllRoles();
    }
    
    @GET
    @Path("/rolebyid/{rid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Role> getRoleById(@PathParam("rid")Integer rid) {
        return al.getRoleById(rid);
    }
     
//    admin
    @POST
    @Path("/addadmin/{aname}/{email}/{password}/{rid}")
    public void addAdmin(@PathParam("aname")String aname, @PathParam("email")String email, @PathParam("password")String password, @PathParam("rid")Integer rid) {
        al.addAdmin(aname, email, password, rid);
    }
        
    @PUT
    @Path("/updateadmin/{aid}/{aname}/{email}/{password}/{rid}")
    public void updateAdmin(@PathParam("aid")Integer aid, @PathParam("aname")String aname, @PathParam("email")String email, @PathParam("password")String password, @PathParam("rid")Integer rid) {
        al.updateAdmin(aid, aname, email, password, rid);
    }
    
    @DELETE
    @Path("/deleteadmin/{aid}")
    public void deleteAdmin(@PathParam("aid")Integer aid) {
        al.deleteAdmin(aid);
    }
    
    @GET
    @Path("/alladmin")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Admin> getAllAdmin() {
        return al.getAllAdmin();
    }
    
    @GET
    @Path("/adminbyid/{aid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Admin> getAdminById(@PathParam("aid")Integer aid) {
        return al.getAdminById(aid);
    }
    
    @GET
    @Path("/adminbyname/{aname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Admin> getAdminbyName(@PathParam("aname")String aname) {
        return al.getAdminbyName(aname);
    }
    
//    blog
    @POST
    @Path("/addblog/{aid}/{title}/{content}/{status}/{tags}")
    public void addBlog(@PathParam("aid")Integer aid, @PathParam("title")String title, @PathParam("content")String content, @PathParam("status")String status, @PathParam("tags")String tags) {
        al.addBlog(aid, title, content, status, tags);
    }
    
    @PUT
    @Path("/updateblog/{blogId}/{aid}/{title}/{content}/{status}/{tags}")
    public void updateBlog(@PathParam("blogId")Integer blog_id, @PathParam("aid")Integer aid, @PathParam("title")String title, @PathParam("content")String content, @PathParam("status")String status, @PathParam("tags")String tags) {
        al.updateBlog(blog_id, aid, title, content, status, tags);
    }
    
    @DELETE
    @Path("/deleteblog/{blogId}")
    public void deleteBlog(@PathParam("blogId")Integer blog_id) {
        al.deleteBlog(blog_id);
    }
    
    @GET
    @Path("/allblog")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Blog> getAllBlog() {
        return al.getAllBlog();
    }
    
    @GET
    @Path("/blogbyid/{blogId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Blog> getBlogByid(@PathParam("blogId")Integer blog_id) {
        return al.getBlogByid(blog_id);
    }
    
    @GET
    @Path("/blogbytitle/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Blog> getBlogByTitle(@PathParam("title")String title) {
        return al.getBlogByTitle(title);
    }
    
    @GET
    @Path("/blogbytag/{tags}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Blog> getBlogByTag(@PathParam("tags")String tags) {
        return al.getBlogByTag(tags);
    }
    
//    brand
    @POST
    @Path("/addbrand/{bname}/{bimg}/{manufacturer}/{countryOrigin}/{siteUrl}")
    public void addBrand(@PathParam("bname")String bname, @PathParam("bimg")String img, @PathParam("manufacturer")String manufacturer, @PathParam("countryOrigin")String country_origin, @PathParam("siteUrl")String site_url) {
        al.addBrand(bname, img, manufacturer, country_origin, site_url);
    }
    
    @PUT
    @Path("/updatebrand/{bid}/{bname}/{bimg}/{manufacturer}/{countryOrigin}/{siteUrl}")
    public void updateBrand(@PathParam("bid")Integer bid, @PathParam("bname")String bname, @PathParam("bimg")String img, @PathParam("manufacturer")String manufacturer, @PathParam("countryOrigin")String country_origin, @PathParam("siteUrl")String site_url) {
        al.updateBrand(bid, bname, img, manufacturer, country_origin, site_url);
    }
    
    @DELETE
    @Path("/deletebrand/{bid}")
    public void deleteBrand(@PathParam("bid")Integer bid) {
        al.deleteBrand(bid);
    }
    
    @GET
    @Path("/allbrand")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Brand> getAllBrands() {
        return al.getAllBrands();
    }
    
    @GET
    @Path("/brandbyname/{bname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Brand> getBrandByBname(@PathParam("bname")String bname) {
        return al.getBrandByBname(bname);
    }  
    
//    category
    @POST
    @Path("/addcategory/{cname}/{description}")
    public void addCategory(@PathParam("cname")String cname, @PathParam("description")String description) {
        al.addCategory(cname, description);
    }
    
    @PUT
    @Path("/updatecategory/{catId}/{cname}/{description}")
    public void updateCategory(@PathParam("catId")Integer cat_id, @PathParam("cname")String cname, @PathParam("description")String description) {
        al.updateCategory(cat_id, cname, description);
    }
    
    @DELETE
    @Path("/deletecategory/{catId}")
    public void deleteCategory(@PathParam("catId")Integer cat_id) {
        al.deleteCategory(cat_id);
    }
    
    @GET
    @Path("/allcategory")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Category> getAllCategories() {
        return al.getAllCategories();
    }
    
    @GET
    @Path("/categorybyname/{cname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Category> getCategoryByCname(@PathParam("cname")String cname) {
        return al.getCategoryByCname(cname);
    }
    
    @POST
    @Path("/addmedicine/{mname}/{img}/{description}/{price}/{quantity}/{availability}/{bid}/{catId}")
    public void addMedicine(@PathParam("mname")String mname, @PathParam("img")String img, @PathParam("description")String description, @PathParam("price")Integer price, @PathParam("quantity")String quantity, @PathParam("availability")String availability, @PathParam("bid")Integer bid, @PathParam("catId")Integer cat_id) {
        al.addMedicine(mname, img, description, price, quantity, availability, bid, cat_id);
    }
    
    @PUT
    @Path("/updatemedicine/{mid}/{mname}/{img}/{description}/{price}/{quantity}/{availability}/{bid}/{catId}")
    public void updateMedicine(@PathParam("mid")Integer mid, @PathParam("mname")String mname, @PathParam("img")String img, @PathParam("description")String description, @PathParam("price")Integer price, @PathParam("quantity")String quantity, @PathParam("availability")String availability, @PathParam("bid")Integer bid, @PathParam("catId")Integer cat_id) {
        al.updateMedicine(mid, mname, img, description, price, quantity, availability, bid, cat_id);
    }
    
    @DELETE
    @Path("/deletemedicine/{mid}")
    public void deleteMedicine(@PathParam("mid")Integer mid) {
        al.deleteMedicine(mid);
    }
    
    @GET
    @Path("/allmedicine")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Medicine> getAllMedicines() {
        return al.getAllMedicines();
    }
    
    @GET
    @Path("/medicinebyname/{mname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Medicine> getMedicineByMname(@PathParam("mname")String mname) {
        return al.getMedicineByMname(mname);
    }
    
    @GET
    @Path("/medicinebyavailability/{availability}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Medicine> getMediByAvailability(@PathParam("availability")String availability) {
        return al.getMediByAvailability(availability);
    }
    
//    cart item
    @POST
    @Path("addcartitem/{cartid}/{mid}/{quantity}/{price}")
    public void addCartItem(@PathParam("cartid")Integer cartid, @PathParam("mid")Integer mid, @PathParam("quantity")Integer quantity, @PathParam("price")BigDecimal price) {
        al.addCartItem(cartid, mid, quantity, BigDecimal.ONE);
    }
    
    @PUT
    @Path("/updatecartitem/{cartItemId}/{cartid}/{mid}/{quantity}/{price}")
    public void updateCartItem(@PathParam("cartItemId")Integer cart_item_id, @PathParam("cartid")Integer cartid, @PathParam("mid")Integer mid, @PathParam("quantity")Integer quantity, @PathParam("price")BigDecimal price) {
        al.updateCartItem(cart_item_id, cartid, mid, quantity, price);
    }
    
    @DELETE
    @Path("/deletecartitem/{cartItemId}")
    public void deleteCartItem(@PathParam("cartItemId")Integer cart_item_id) {
        al.deleteCartItem(cart_item_id);
    }
    
    @GET
    @Path("/allcartitem")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<CartItem> getAllCartItems() {
        return al.getAllCartItems();
    }
    
//    order manage
    @POST
    @Path("/addordermanage/{oid}/{status}")
    public void addOrderManage(@PathParam("oid")Integer oid, @PathParam("status")String status) {
        al.addOrderManage(oid, status);        
    }

    @PUT
    @Path("/updateordermanage/{manageId}/{oid}/{status}")
    public void updateOrderManage(@PathParam("manageId")Integer manage_id, @PathParam("oid")Integer oid, @PathParam("status")String status) {
        al.updateOrderManage(manage_id, oid, status);
    }
    
    @DELETE
    @Path("/deleteordermanage/{manageId}")
    public void deleteOrderManage(@PathParam("manageId")Integer manage_id) {
        al.deleteOrderManage(manage_id);
    }
    
    @GET
    @Path("/allordermanage")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<OrderManage> getAllOrderManages() {
        return al.getAllOrderManages();
    }
    
    @GET
    @Path("/ordermanagebystatus/{status}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<OrderManage> getStatus(@PathParam("status")String status) {
        return al.getStatus(status);
    }
    
//    inventory manage
    @POST
        @Path("/addinventory/{mid}/{quantity}/{action}/{managedBy}/{notes}")
    public void addInventory(@PathParam("mid")Integer mid, @PathParam("quantity")Integer quantity, @PathParam("action")String action, @PathParam("managedBy")Integer managed_by, @PathParam("notes")String notes) {
        al.addInventory(mid, quantity, action, managed_by, notes);
    }
    
    @PUT
    @Path("/updateinventory/{inventoryId}/{mid}/{quantity}/{action}/{managedBy}/{notes}")
    public void updateInventory(@PathParam("inventoryId")Integer inventory_id, @PathParam("mid")Integer mid, @PathParam("quantity")Integer quantity, @PathParam("action")String action, @PathParam("managedBy")Integer managed_by, @PathParam("notes")String notes) {
        al.updateInventory(inventory_id, mid, quantity, action, managed_by, notes);
    }

    @DELETE
    @Path("/deleteinventory/{inventoryId}")
    public void deleteInventory(@PathParam("inventoryId")Integer inventory_id) {
        al.deleteInventory(inventory_id);
    }
    
    @GET
    @Path("/allinventory")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<InventoryManage> getAllInventories() {
        return al.getAllInventories();
    }

    @GET
    @Path("/inventorybyaction/{action}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<InventoryManage> getInventoryByAction(@PathParam("action")String action) {
        return al.getInventoryByAction(action);
    }
    
//    user data
    
    @GET
    @Path("/alluser")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<UserMst> getAllUsers() {
        return al.getAllUsers();
    }
    
    @GET
    @Path("/userbyname/{uname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<UserMst> getUserByUname(@PathParam("uname")String uname) {
        return al.getUserByUname(uname);
    }
    
    @GET
    @Path("/userbyemail/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<UserMst> getUserByEmail(@PathParam("email")String email) {
        return al.getUserByEmail(email);
    }
    
//    form detail of user
    
    @GET
    @Path("/allform")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Form> getAllForm() {
        return al.getAllForm();
    }
    
    @GET
    @Path("/formbyid/{formId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Form> getFormByFormId(@PathParam("formId")Integer form_id) {
        return al.getFormByFormId(form_id);
    }
    
    @GET
    @Path("/formbyfname/{fname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Form> getFormByFname(@PathParam("fname")String fname) {
        return al.getFormByFname(fname);
    }
    
//    feedback detail
    @GET
    @Path("/allfeedback")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Feedback> getAllFeedback() {
        return al.getAllFeedback();
    }

    @GET
    @Path("/feedbackbyid/{fid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Feedback> getFeedbackByFid(@PathParam("fid")Integer fid) {
        return al.getFeedbackByFid(fid);
    }
    
//    order by user
    @GET
    @Path("/allorder")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Order1> getAllOrders() {
        return al.getAllOrders();
    }

    @GET
    @Path("/orderbyid/{oid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Order1> getOrderByOid(@PathParam("oid")Integer oid) {
        return al.getOrderByOid(oid);
    }
    
    @GET
    @Path("/orderbystatus/{status}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Order1> getOrderByStatus(@PathParam("status")String status) {
        return al.getOrderByStatus(status);
    }
    
}
