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

public class LoginController extends HttpServlet {

private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();

		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/jewelry-server/rest/user/login");

		String input = "{\"username\":" + username + ",\"password\":" + password + "}";

			System.out.println(input);
		
		ClientResponse res = webResource.type("application/json").post(ClientResponse.class, input);
		JSONObject output = res.getEntity(JSONObject.class);
		
		System.out.println(output);
		
		session.setAttribute("username", username);
		
		if(res.getStatus() == 200){
			response.sendRedirect("nextPage.jsp");
		} else {
			response.sendRedirect("invalidLogin.jsp");
		}
	}
}