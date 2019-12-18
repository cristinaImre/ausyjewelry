package ro.ausy.jewelry.server.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.ausy.jewelry.commons.dto.UserDTO;
import ro.ausy.jewelry.server.business.UserManager;

@Component
@Path("/user")
public class UserService {
	/**
	 * this is an object of UserManager class.
	 */
	@Autowired
	private transient UserManager userManager;
	
	/**
	 * 
	 * @param userId
	 * userId.
	 * @return 
	 * user by ID
	 */
	@GET
	@Path("/id/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public final UserDTO getUserById(@PathParam("userId")final int userId) {
		return userManager.getUserById(userId);
	}
	
}
