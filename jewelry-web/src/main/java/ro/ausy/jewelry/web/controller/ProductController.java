package ro.ausy.jewelry.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ProductController extends HttpServlet {

	public static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String productId = req.getParameter("productId");
		String productName = req.getParameter("productName");

		Client client = Client.create();
		if (productName != null) {
			WebResource webResource = client.resource("http://localhost:8080/jewelry-server/rest/product/insert");
			//String product = "{\"productName\":" + productName + "}";
			JSONObject jsonProductName = null;
			try {
				jsonProductName = new JSONObject("{\"productName\":" + productName + "}");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, jsonProductName);
			res.sendRedirect("productsAdmin.jsp");
		}

		if (productId != null) {
			WebResource webResource1 = client.resource("http://localhost:8080/jewelry-server/rest/product/delete");
			String product = "{\"productId\":" + productId + "}";
			ClientResponse response1 = webResource1.type("applicaion/json").post(ClientResponse.class, product);
			res.sendRedirect("productsAdmin.jsp");
		}
	}
}
