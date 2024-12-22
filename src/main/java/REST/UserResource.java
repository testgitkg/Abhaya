/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package REST;

import ejb.userLocal;
import entity.Cart;
import entity.Order1;
import entity.OrderItem;
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
import java.math.BigInteger;
import java.util.Collection;

/**
 * REST Web Service
 *
 * @author abhaya
 */
@Path("User")
@RequestScoped
public class UserResource {
    
    @EJB userLocal ul;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserResource
     */
    public UserResource() {
    }

    /**
     * Retrieves representation of an instance of REST.UserResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of UserResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
//    user
    @POST
    @Path("adduser/{uname}/{email}/{password}/{address}/{rid}")
    public void addUserMst(@PathParam("uname")String uname, @PathParam("email")String email, @PathParam("password")String password, @PathParam("address")String address, @PathParam("rid")Integer rid) {
        ul.addUserMst(uname, email, password, address, rid);
    }       
    
    @PUT
    @Path("updateuser/{uid}/{uname}/{email}/{password}/{address}/{rid}")
    public void updateUserMst(@PathParam("uid")Integer uid, @PathParam("uname")String uname, @PathParam("email")String email, @PathParam("password")String password, @PathParam("address")String address, @PathParam("rid")Integer rid){
        ul.updateUserMst(uid,uname, email, password, address, rid);   
}
    @DELETE
    @Path("deleteuser/{uid}")
    public void deleteUserMst(@PathParam("uid")Integer uid){
        ul.deleteUserMst(uid);
    }
    
    @GET
    @Path("/alluser")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<UserMst> getAllUserMst(){
        return ul.getAllUsers();
    }
    
//    cart
    @POST
    @Path("addcart/{uid}/{status}")
    public void addCart(@PathParam("uid")Integer uid, @PathParam("status")String status){
        ul.addCart(uid, status);
    }
    
    @PUT
    @Path("updatecart/{cartid}/{uid}/{status}")
    public void updateCart(@PathParam("cartid")Integer cartid, @PathParam("uid")Integer uid, @PathParam("status")String status){
        ul.updateCart(cartid, uid, status);
    }
    
    @DELETE
    @Path("deletecart/{cartid}")
    public void deleteCart(@PathParam("cartid")Integer cartid){
       ul.deleteCart(cartid);
    }
    
    @GET
    @Path("/allcart")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Cart> getAllCart(){
        return ul.getAllCart();
    }
    
//    form
    @POST
    @Path("addform/{uid}/{fname}/{mno}/{gender}/{dob}/{height}/{weight}/{address}")
    public void addForm(@PathParam("uid")Integer uid, @PathParam("fname") String fname, @PathParam("mno")BigInteger mno, @PathParam("gender") String gender, @PathParam("dob")String dob, @PathParam("height") Integer height, @PathParam("weight")Integer weight, @PathParam("address") String address){
        ul.addForm(uid, fname, mno, gender, dob, height, weight, address);
    }
    
    @PUT
    @Path("updateform/{formId}/{uid}/{fname}/{mno}/{gender}/{dob}/{height}/{weight}/{address}")
    public void updateForm(@PathParam("formId")Integer form_id, @PathParam("uid")Integer uid, @PathParam("fname") String fname, @PathParam("mno")BigInteger mno, @PathParam("gender") String gender, @PathParam("dob")String dob,@PathParam("height") Integer height, @PathParam("weight")Integer weight, @PathParam("address") String address){
        ul.updateForm(form_id, uid, fname, mno, gender, dob, height, weight, address);
    }     
    
    @DELETE
    @Path("deleteform/{formId}")
    public void deleteForm(@PathParam("formId")Integer form_id){
       ul.deleteForm(form_id);
    }    
    
//    feedback
    @POST
    @Path("addfeedback/{uid}/{rating}/{comments}")
    public void addFeedback(@PathParam("uid")Integer uid, @PathParam("rating")Integer rating, @PathParam("comments")String comments){
        ul.addFeddback(uid, rating, comments);
    }
    
    @PUT
    @Path("updatefeedback/{fid}/{uid}/{rating}/{comments}")
    public void updateFeedback(@PathParam("fid")Integer fid, @PathParam("uid")Integer uid, @PathParam("rating")Integer rating, @PathParam("comments")String comments){
        ul.updateFeedback(fid, uid, rating, comments);
    }
    
    @DELETE
    @Path("deletefeedback/{fid}")
    public void deleteFeedback(@PathParam("fid")Integer fid){
        ul.deleteFeedback(fid);
    }
    
//    order
    @POST
    @Path("addorder/{uid}/{status}/{totalAmt}/{shippingAdd}/{paymentStatus}/{paymentMethod}")
    public void addOrder(@PathParam("uid")Integer uid, @PathParam("status") String status, @PathParam("totalAmt")BigDecimal total_amt, @PathParam("shippingAdd") String shipping_add, @PathParam("paymentStatus") String payment_status, @PathParam("paymentMethod") String payment_method){
        ul.addOrder(uid, status, total_amt, shipping_add, payment_status, payment_method);
    }
    
    @PUT
    @Path("updateorder/{oid}/{uid}/{status}/{totalAmt}/{shippingAdd}/{paymentStatus}/{paymentMethod}")
    public void updateOrder(@PathParam("oid")Integer oid, @PathParam("uid")Integer uid, @PathParam("status") String status, @PathParam("totalAmt")BigDecimal total_amt, @PathParam("shippingAdd") String shipping_add, @PathParam("paymentStatus") String payment_status, @PathParam("paymentMethod") String payment_method){
        ul.updateOrder(oid, uid, status, total_amt, shipping_add, payment_status, payment_method);
    }
    
    @DELETE
    @Path("deleteorder/{oid}")
    public void deleteOrder(@PathParam("oid")Integer oid){
        ul.deleteOrder(oid);
    }    
    
    @GET
    @Path("/allorder")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Order1> getAllOrder(){
        return ul.getAllOrders();
    }
    
//    order item
    @POST
    @Path("addorderitem/{oid}/{mid}/{quantity}/{price}/{totalAmt}")
    public void addOrderItem(@PathParam("oid")Integer oid, @PathParam("mid") Integer mid, @PathParam("quantity") Integer quantity, @PathParam("price") BigDecimal price, @PathParam("totalAmt") BigDecimal total_amt){
       ul.addOrderItem(oid, mid, quantity, price, total_amt);
    }   
    
    @PUT
    @Path("updateorderitem/{orderItemId}/{oid}/{mid}/{quantity}/{price}/{totalAmt}")
    public void updateOrderItem(@PathParam("orderItemId")Integer order_item_id, @PathParam("oid")Integer oid, @PathParam("mid") Integer mid, @PathParam("quantity") Integer quantity, @PathParam("price") BigDecimal price, @PathParam("totalAmt") BigDecimal total_amt){
       ul.updateOrderItem(order_item_id, oid, mid, quantity, price, total_amt);
    }
    
    @DELETE
    @Path("deleteorderitem/{orderItemId}")
    public void deleteOrderItem(@PathParam("orderItemId")Integer order_item_id){
       ul.deleteOrderItem(order_item_id);
    }
    
    @GET
    @Path("/allorderitem")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<OrderItem> getAllOrderItem(){
        return ul.getAllOrderItems();
    }
    
}
