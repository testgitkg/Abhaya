/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:UserResource [User]<br>
 * USAGE:
 * <pre>
 *        userClient client = new userClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author 1
 */
public class userClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/abhaya/resources";

    public userClient() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("User");
    }

    public void addCart(String uid, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addcart/{0}/{1}", new Object[]{uid, status})).request().post(null);
    }

    public <T> T getAllOrder(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allorder");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addFeedback(String uid, String rating, String comments) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addfeedback/{0}/{1}/{2}", new Object[]{uid, rating, comments})).request().post(null);
    }

    public void addForm(String uid, String fname, String mno, String gender, String dob, String height, String weight, String address) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addform/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{uid, fname, mno, gender, dob, height, weight, address})).request().post(null);
    }

    public void updateOrderItem(String orderItemId, String oid, String mid, String quantity, String price, String totalAmt) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateorderitem/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{orderItemId, oid, mid, quantity, price, totalAmt})).request().put(null);
    }

    public void deleteFeedback(String fid, String uid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deletefeedback/{0}/{1}", new Object[]{fid, uid})).request().delete();
    }

    public void deleteForm(String formId, String uid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteform/{0}/{1}", new Object[]{formId, uid})).request().delete();
    }

    public String getXml() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_XML).get(String.class);
    }

    public void updateUserMst(String uid, String uname, String email, String password, String address, String rid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateuser/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{uid, uname, email, password, address, rid})).request().put(null);
    }

    public void updateOrder(String oid, String uid, String status, String totalAmt, String shippingAdd, String paymentStatus, String paymentMethod) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateorder/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{oid, uid, status, totalAmt, shippingAdd, paymentStatus, paymentMethod})).request().put(null);
    }

    public void addOrderItem(String oid, String mid, String quantity, String price, String totalAmt) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addorderitem/{0}/{1}/{2}/{3}/{4}", new Object[]{oid, mid, quantity, price, totalAmt})).request().post(null);
    }

    public void putXml(Object requestEntity) throws ClientErrorException {
        webTarget.request(jakarta.ws.rs.core.MediaType.APPLICATION_XML).put(jakarta.ws.rs.client.Entity.entity(requestEntity, jakarta.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public <T> T getAllCart(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allcart");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteCart(String cartid, String uid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deletecart/{0}/{1}", new Object[]{cartid, uid})).request().delete();
    }

    public void deleteOrderItem(String orderItemId, String oid, String mid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteorderitem/{0}/{1}/{2}", new Object[]{orderItemId, oid, mid})).request().delete();
    }

    public void addOrder(String uid, String status, String totalAmt, String shippingAdd, String paymentStatus, String paymentMethod) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addorder/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{uid, status, totalAmt, shippingAdd, paymentStatus, paymentMethod})).request().post(null);
    }

    public <T> T getAllOrderItem(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allorderitem");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addUserMst(String uname, String email, String password, String address, String rid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("adduser/{0}/{1}/{2}/{3}/{4}", new Object[]{uname, email, password, address, rid})).request().post(null);
    }

    public void updateForm(String formId, String uid, String fname, String mno, String gender, String dob, String height, String weight, String address) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateform/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}", new Object[]{formId, uid, fname, mno, gender, dob, height, weight, address})).request().put(null);
    }

    public void deleteOrder(String oid, String uid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteorder/{0}/{1}", new Object[]{oid, uid})).request().delete();
    }

    public <T> T getAllUserMst(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("alluser");
        return resource.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateCart(String cartid, String uid, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatecart/{0}/{1}/{2}", new Object[]{cartid, uid, status})).request().put(null);
    }

    public void updateFeedback(String fid, String uid, String rating, String comments) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatefeedback/{0}/{1}/{2}/{3}", new Object[]{fid, uid, rating, comments})).request().put(null);
    }

    public void deleteUserMst(String uid, String rid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteuser/{0}/{1}", new Object[]{uid, rid})).request().delete();
    }

    public void close() {
        client.close();
    }
    
}
