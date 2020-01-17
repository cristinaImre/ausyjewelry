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

import ro.ausy.jewelry.commons.dto.ProductDTO;
import ro.ausy.jewelry.server.business.ProductManager;
import ro.ausy.jewelry.server.dao.ProductDao;
import ro.ausy.jewelry.server.entity.Product;

@Component
@Path("/product")
public class ProductService {
	
	@Autowired
	private transient ProductManager productManager;
	
	/**
	 * @param productId 
	 * productId.
	 * @return
	 * product by ID.
	 */
//	@GET
//	@Path("/id/{productId}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public final ProductDTO getProductById(@PathParam("productId")final int productId) {
//		return productManager.getProductById(productId);
//	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public final List<ProductDTO> list() {
		return productManager.getAllProduct();
	}
	
	@POST
	@Path("/insert")
	@Produces(MediaType.APPLICATION_JSON)
	public final void insertProduct(String product) throws JSONException {
		JSONObject jsonObj;
		jsonObj = new JSONObject(product);
		String productName = jsonObj.getString("productName");
		productManager.insertProduct(productName);
	}
	
	
	@POST
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public final void deleteProduct(String product) throws JSONException {
		JSONObject jsonObj;
		jsonObj = new JSONObject(product);
		int productId = jsonObj.getInt("productId");
		productManager.deleteProduct(productId);
	}
}

