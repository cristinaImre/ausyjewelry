package ro.ausy.jewelry.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		Client c = Client.create();

		WebResource webResource = c.resource("http://localhost:8080/jewelry-server/user/login");

		String input = "{\"username\":" + username + ",\"password\":" + password + "}";

		ClientResponse res = webResource.type("application/json").post(ClientResponse.class, input);
		JSONObject output = res.getEntity(JSONObject.class);		
	}
}
