import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ro.ausy.jewelry.commons.dto.ProductDTO;
import ro.ausy.jewelry.commons.dto.UserDTO;
import ro.ausy.jewelry.server.business.ProductManager;
import ro.ausy.jewelry.server.business.UserManager;


public class AppMain {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		final ApplicationContext appContext = new ClassPathXmlApplicationContext("application-beans.xml");
		
		final UserManager userManager = appContext.getBean(UserManager.class);
		//final ProductManager productManager = appContext.getBean(ProductManager.class);
		
		//final UserDTO user = new UserDTO(5, "user", "password", null);		
		//final ProductDTO product = new ProductDTO(6, "apa");
		
		//userManager.insertUser(user);
		//productManager.insertProduct(product);
		final UserDTO user = new UserDTO();
		user.setUserDTOId(5);
		userManager.deleteUser(user);

	}

}
