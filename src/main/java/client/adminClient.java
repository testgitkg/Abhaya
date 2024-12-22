/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:AdminResource [Admin]<br>
 * USAGE:
 * <pre>
 *        adminClient client = new adminClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author 1
 */
public class adminClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/abhaya/resources";

    public adminClient() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("Admin");
    }

    public void updateCartItem(String cartItemId, String cartid, String mid, String quantity, String price) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatecartitem/{0}/{1}/{2}/{3}/{4}", new Object[]{cartItemId, cartid, mid, quantity, price})).request().post(null);
    }

    public void updateRole(String rid, String roleName) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updaterole/{0}/{1}", new Object[]{rid, roleName})).request().post(null);
    }

    public <T> T getOrderByOid(Class<T> responseType, String oid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("orderbyid/{0}", new Object[]{oid}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addAdmin(String aname, String email, String password, String rid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addadmin/{0}/{1}/{2}/{3}", new Object[]{aname, email, password, rid})).request().post(null);
    }

    public void updateBrand(String bid, String bname, String bimg, String manufacturer, String countryOrigin, String siteUrl) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatebrand/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{bid, bname, bimg, manufacturer, countryOrigin, siteUrl})).request().post(null);
    }

    public void updateCategory(String catId, String cname, String description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatecategory/{0}/{1}/{2}", new Object[]{catId, cname, description})).request().post(null);
    }

    public <T> T getBlogByid(Class<T> responseType, String blogId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("blogbyid/{0}", new Object[]{blogId}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getStatus(Class<T> responseType, String status) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("ordermanagebystatus/{0}", new Object[]{status}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateMedicine(String mid, String mname, String img, String description, String price, String quantity, String availability, String bid, String catId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatemedicine/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}", new Object[]{mid, mname, img, description, price, quantity, availability, bid, catId})).request().post(null);
    }

    public <T> T getAllOrders(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allorder");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteAdmin(String aid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteadmin/{0}", new Object[]{aid})).request().delete();
    }

    public void deleteBrand(String bid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deletebrand/{0}", new Object[]{bid})).request().delete();
    }

    public <T> T getInventoryByAction(Class<T> responseType, String action) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("inventorybyaction/{0}", new Object[]{action}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteOrderManage(String manageId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteordermanage/{0}", new Object[]{manageId})).request().delete();
    }

    public <T> T getAllBrands(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allbrand");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getBlogByTag(Class<T> responseType, String tags) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("blogbytag/{0}", new Object[]{tags}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteCartItem(String cartItemId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deletecartitem/{0}", new Object[]{cartItemId})).request().delete();
    }

    public void addOrderManage(String oid, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addordermanage/{0}/{1}", new Object[]{oid, status})).request().post(null);
    }

    public <T> T getAllUsers(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("alluser");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateAdmin(String aid, String aname, String email, String password, String rid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateadmin/{0}/{1}/{2}/{3}/{4}", new Object[]{aid, aname, email, password, rid})).request().post(null);
    }

    public <T> T getAllForm(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allform");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllMedicines(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allmedicine");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getMediByAvailability(Class<T> responseType, String availability) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("medicinebyavailability/{0}", new Object[]{availability}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getRoleById(Class<T> responseType, String rid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("rolebyid/{0}", new Object[]{rid}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAdminById(Class<T> responseType, String aid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("adminbyid/{0}", new Object[]{aid}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateOrderManage(String manageId, String oid, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateordermanage/{0}/{1}/{2}", new Object[]{manageId, oid, status})).request().post(null);
    }

    public <T> T getAllInventories(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allinventory");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addRole(String roleName) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addrole/{0}", new Object[]{roleName})).request().post(null);
    }

    public <T> T getUserByUname(Class<T> responseType, String uname) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("userbyname/{0}", new Object[]{uname}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllRoles(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allroles");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getBlogByTitle(Class<T> responseType, String title) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("blogbytitle/{0}", new Object[]{title}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addMedicine(String mname, String img, String description, String price, String quantity, String availability, String bid, String catId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addmedicine/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{mname, img, description, price, quantity, availability, bid, catId})).request().post(null);
    }

    public <T> T getOrderByStatus(Class<T> responseType, String status) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("orderbystatus/{0}", new Object[]{status}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteBlog(String blogId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteblog/{0}", new Object[]{blogId})).request().delete();
    }

    public <T> T getFormByFname(Class<T> responseType, String fname) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("formbyfname/{0}", new Object[]{fname}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllBlog(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allblog");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void putXml(Object requestEntity) throws ClientErrorException {
        webTarget.request(jakarta.ws.rs.core.MediaType.APPLICATION_XML).put(jakarta.ws.rs.client.Entity.entity(requestEntity, jakarta.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void addCategory(String cname, String description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addcategory/{0}/{1}", new Object[]{cname, description})).request().post(null);
    }

    public void addCartItem(String cartid, String mid, String quantity, String price) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addcartitem/{0}/{1}/{2}/{3}", new Object[]{cartid, mid, quantity, price})).request().post(null);
    }

    public <T> T getAllFeedback(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allfeedback");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addBrand(String bname, String bimg, String manufacturer, String countryOrigin, String siteUrl) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addbrand/{0}/{1}/{2}/{3}/{4}", new Object[]{bname, bimg, manufacturer, countryOrigin, siteUrl})).request().post(null);
    }

    public void deleteInventory(String inventoryId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteinventory/{0}", new Object[]{inventoryId})).request().delete();
    }

    public void updateBlog(String blogId, String aid, String title, String content, String status, String tags) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateblog/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{blogId, aid, title, content, status, tags})).request().post(null);
    }

    public void addBlog(String aid, String title, String content, String status, String tags) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addblog/{0}/{1}/{2}/{3}/{4}", new Object[]{aid, title, content, status, tags})).request().post(null);
    }

    public <T> T getBrandByBname(Class<T> responseType, String bname) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("brandbyname/{0}", new Object[]{bname}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String getXml() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_XML).get(String.class);
    }

    public <T> T getAllCategories(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allcategory");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addInventory(String mid, String quantity, String action, String managedBy, String notes) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addinventory/{0}/{1}/{2}/{3}/{4}", new Object[]{mid, quantity, action, managedBy, notes})).request().post(null);
    }

    public void deleteRole(String rid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleterole/{0}", new Object[]{rid})).request().delete();
    }

    public void deleteCategory(String catId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deletecategory/{0}", new Object[]{catId})).request().delete();
    }

    public <T> T getUserByEmail(Class<T> responseType, String email) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("userbyemail/{0}", new Object[]{email}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getFormByFormId(Class<T> responseType, String formId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("formbyid/{0}", new Object[]{formId}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllCartItems(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allcartitem");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCategoryByCname(Class<T> responseType, String cname) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("categorybyname/{0}", new Object[]{cname}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllOrderManages(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allordermanage");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteMedicine(String mid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deletemedicine/{0}", new Object[]{mid})).request().delete();
    }

    public <T> T getAdminbyName(Class<T> responseType, String aname) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("adminbyname/{0}", new Object[]{aname}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateInventory(String inventoryId, String mid, String quantity, String action, String managedBy, String notes) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateinventory/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{inventoryId, mid, quantity, action, managedBy, notes})).request().post(null);
    }

    public <T> T getFeedbackByFid(Class<T> responseType, String fid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("feedbackbyid/{0}", new Object[]{fid}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getMedicineByMname(Class<T> responseType, String mname) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("medicinebyname/{0}", new Object[]{mname}));
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllAdmin(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("alladmin");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
