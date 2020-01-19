package ro.ausy.jewelry.server.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.ausy.jewelry.commons.dto.UserDTO;
import ro.ausy.jewelry.server.business.UserManager;

@Component
@Path("/user")
public class UserService {

	@Autowired
	private transient UserManager userManager;

	@GET
	@Path("/id/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public final UserDTO getUserById(@PathParam("userId") final int userId) {
		return userManager.getUserById(userId);
	}
	
	@GET
	@Path("/name/{userName}")
	@Produces(MediaType.APPLICATION_JSON)
	public final UserDTO getUserByName(@PathParam("userName") final String userName) {
		return userManager.getUserByName(userName);
	}
	
	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDTO> getUsers() {
		return userManager.getAllUser();
	}

	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public UserDTO login(String user) throws JSONException {
		JSONObject jsonObj;
		jsonObj = new JSONObject(user);
		String userName = jsonObj.getString("userName");
		String password = jsonObj.getString("password");
		
		return userManager.login(userName, password);
	}
//
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Path("/registration")
//	public final Response saveUser(final UserDTO user) {
//		userManager.insertUser(user);
//		return Response.status(201).build();
//	}
//	
//	

}
