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

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ro.ausy.jewelry.commons.dto.UserDTO;
import ro.ausy.jewelry.server.business.UserManager;
import ro.ausy.jewelry.server.dao.UserDao;

@Path("/user")
public class UserService {

	final ApplicationContext appContextDTO = new ClassPathXmlApplicationContext("applicationContextDto.xml");
	ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	UserDao userDao = appContext.getBean(UserDao.class);

	/**
	 * this is an object of UserManager class.
	 */
	@Autowired
	private transient UserManager userManager = appContextDTO.getBean(UserManager.class);

	@GET
	@Path("/id/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public final UserDTO getUserById(@PathParam("userId") final int userId) {
		return userManager.getUserById(userId);
	}
	
	@GET
	@Path("/users")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<UserDTO> getUsers() {
		return userManager.getAllUser();
	}

	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public UserDTO login(String user) {

		JSONObject jsonObj;

		try {
			jsonObj = new JSONObject(user);
			String username = jsonObj.getString("username");
			String password = jsonObj.getString("password");

			return userManager.login(username, password);

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/registration")
	public final Response saveUser(@PathParam("userName") String userName, @PathParam("password") String password) {
		UserDTO user = new UserDTO();
		user.setUserName(userName);
		user.setPassword(password);
		userManager.insertUser(user);
		return Response.status(201).build();
	}
	
	

}
