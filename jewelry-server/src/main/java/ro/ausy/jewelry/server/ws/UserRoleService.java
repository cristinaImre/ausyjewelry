package ro.ausy.jewelry.server.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.ausy.jewelry.commons.dto.UserRoleDTO;
import ro.ausy.jewelry.server.business.UserRoleManager;

@Component
@Path("/userRole")
public class UserRoleService {
	
	@Autowired
	private transient UserRoleManager userRoleManager;

	/**
	 * @param userRoleId userRoleId.
	 * @return This method will return an UserRole by id.
	 */
	@POST
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
