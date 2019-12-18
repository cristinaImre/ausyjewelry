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

import ro.ausy.jewelry.commons.dto.ProductDTO;
import ro.ausy.jewelry.server.business.ProductManager;

@Component
@Path("/product")
public class ProductService {
	/**
	 * This is an object of ProductManager class.
	 */
	@Autowired
	private transient ProductManager productManager;
	
	/**
	 * @param productId 
	 * productId.
	 * @return
	 * product by ID.
	 */
	@GET
	@Path("/id/{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	public final ProductDTO getProductById(@PathParam("productId")final int productId) {
		return productManager.getProductById(productId);
	}

}

