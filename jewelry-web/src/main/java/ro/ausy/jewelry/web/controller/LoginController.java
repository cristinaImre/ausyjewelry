package ro.ausy.jewelry.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import ro.ausy.jewelry.commons.dto.ProductDTO;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		/*
		 * LOGIN
		 */
		JSONObject jsonUser = null;
		try {
			jsonUser = new JSONObject("{\"userName\":" + username + ",\"password\":" + password + "}");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/jewelry-server/rest/user/login");
		ClientResponse res = webResource.type("application/json").post(ClientResponse.class, jsonUser);
		JSONObject output = res.getEntity(JSONObject.class);
		
		/*
		 * Getting userRole
		 */
		JSONArray userRole;
		String userRoleName = "";
		try {
			userRole = output.getJSONArray("userRoleDTOList");
		    for(int i = 0 ; i < userRole.length(); i++){
		        JSONObject p = (JSONObject)userRole.get(i);
		        userRoleName = p.getString("userRoleName");
		    }
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		/*
		 * Display all products on productsAdmin page and products page.
		 */
		Client client1 = Client.create();
		WebResource webResource1 = client1.resource("http://localhost:8080/jewelry-server/rest/product");
		ClientResponse res1 = webResource1.type("application/json").get(ClientResponse.class);
		JSONArray result = res1.getEntity(JSONArray.class);
		int p = 0;
		JSONObject obj = new JSONObject();
		List<ProductDTO> products = new ArrayList<ProductDTO>();
		while (p < result.length()) {
			try {
				obj = result.getJSONObject(p);
				ProductDTO productDTO = new ProductDTO();
				productDTO.setProductDTOId(obj.getInt("productDTOId"));
				productDTO.setProductName(obj.getString("productName"));
				products.add(productDTO);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			p++;
		}
		session.setAttribute("products", products);
		
		session.setAttribute("userName", username);
		
		if(output.isNull("userName")){
			response.sendRedirect("invalidLogin.jsp");
		} else {
			if(userRoleName.equalsIgnoreCase("admin")) {
				response.sendRedirect("productsAdmin.jsp");
			} else {
				response.sendRedirect("products.jsp");
			}
		}
		
	}

}