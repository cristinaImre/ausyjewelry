package ro.ausy.jewelry.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import ro.ausy.jewelry.commons.dto.ProductDTO;

public class ProductController extends HttpServlet {
	
	public static final long serialVersionUID = 1L;
	
//	protected void doPost(HttpServletRequest request,HttpServletResponse response )
//			throws ServletException, IOException {
//		
//		String productName = request.getParameter("productName");
//		HttpSession session = request.getSession();
//		
//		JSONObject jsonProduct = null;
//		try {
//			jsonProduct = new JSONObject("{\"productName\":" + productName + "}"); 
//		} catch(JSONException e) {
//			e.printStackTrace();
//		}
		
////		Client client = Client.create();
////		WebResource webResource = client.resource("http://localhost:8080/jewelry-server/rest/product/list");
////		
//		ClientResponse res = webResource.type("application.json").post(ClientResponse.class, jsonProduct);
//		JSONObject output = res.getEntity(JSONObject.class);
//	}
//		List<ProductDTO> getAllProduct() {
//			return productManager.getAllProduct();
	
}
