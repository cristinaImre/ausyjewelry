package ro.ausy.jewelry.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

@WebServlet("/cart")
public class CartController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public CartController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			doGet_DisplayCart(request, response);
		} else {
			if (action.equalsIgnoreCase("buy")) {
				doGet_Buy(request, response);
			}
		}
	}

	protected void doGet_DisplayCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

	protected void doGet_Buy(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String productId = request.getParameter("productId");

		Client client = Client.create();
		WebResource webResource1 = client.resource("http://localhost:8080/jewelry-server/rest/product/id");
		JSONObject jsonProduct = null;
		try {
			jsonProduct = new JSONObject("{\"productId\":" + productId + "}");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClientResponse resp = webResource1.type("application/json").post(ClientResponse.class, jsonProduct);
		JSONObject result = resp.getEntity(JSONObject.class);

		if (session.getAttribute("cart") == null) {
			int i = 1;
			List<ProductDTO> cart = new ArrayList<ProductDTO>();
			while (i < result.length()) {
				try {
					ProductDTO productDTO = new ProductDTO();
					productDTO.setProductDTOId(result.getInt("productDTOId"));
					productDTO.setProductName(result.getString("productName"));
					cart.add(productDTO);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				i++;
				session.setAttribute("cart", cart);
			}
		} else {
			List<ProductDTO> cart = (List<ProductDTO>) session.getAttribute("cart");
			int index = isExisting(request.getParameter("id"), cart);
			if (index == -1) {
				try {
					ProductDTO productDTO = new ProductDTO();
					productDTO.setProductDTOId(result.getInt("productDTOId"));
					productDTO.setProductName(result.getString("productName"));
					cart.add(productDTO);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				session.setAttribute("cart", cart);
			}
		}
		response.sendRedirect("cart");
	}

	private int isExisting(String id, List<ProductDTO> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProductName().equalsIgnoreCase(id)) {
				return i;
			}
		}
		return -1;
	}

}
