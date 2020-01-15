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

public class ProductController extends HttpServlet {

	public static final long serialVersionUID = 1L;

	/*
	 * Display all products on productsAdmin page and products page.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/jewelry-server/rest/product");
		ClientResponse res = webResource.type("application/json").get(ClientResponse.class);
		JSONArray result = res.getEntity(JSONArray.class);
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
	}
}
