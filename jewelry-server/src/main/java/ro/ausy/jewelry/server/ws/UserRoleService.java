package ro.ausy.jewelry.server.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import ro.ausy.jewelry.commons.dto.UserRoleDTO;
import ro.ausy.jewelry.server.business.UserRoleManager;

@Path("/user_role")
public class UserRoleService {
	
	/**
	 * This is an object of UserRoleManager class.
	 */
	@Autowired
	private transient UserRoleManager userRoleManager;
	
	/**
	 * @param userRoleId userRoleId.
	 * @return This method will return an UserRole by id.
	 */
	@GET
	@Path("/{userRoleId}")
	@Produces(MediaType.APPLICATION_JSON)
	public final UserRoleDTO getUserRoleById(@PathParam("userRoleId")final int userRoleId) {
		return userRoleManager.getUserRoleById(userRoleId);	
	}
	
	/**
	 * @return
	 * This method will return all userRoles.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public final List<UserRoleDTO> getAllUserRole() {
		return userRoleManager.getAllUserRole();
	}
	
	
	

}
