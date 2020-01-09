package ro.ausy.jewelry.web.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * UserService used to get responses from server.
 * @author cimre
 *
 */
public class UserBusinessService {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		HttpSession session = req.getSession();
		Client client = Client.create();

		WebResource webResourceUsers = client.resource("http://localhost:8080/jewelry-server/user/users");
		ClientResponse responseUser = webResourceUsers.type("application/json").get(ClientResponse.class);
		JSONObject resultLogin = responseUser.getEntity(JSONObject.class);

		String userName = "";
		String password = "";

		try {
			userName = resultLogin.getString("users");
			password = resultLogin.getString("password");

		} catch (Exception e) {
		}

		JSONArray jArray = new JSONArray();
		try {
			jArray = resultLogin.getJSONArray("users");
		} catch (JSONException e1) {
			e1.printStackTrace();
		}

	}

}
