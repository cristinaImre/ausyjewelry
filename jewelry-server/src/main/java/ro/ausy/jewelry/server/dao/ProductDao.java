package ro.ausy.jewelry.server.dao;

import java.util.List;

import ro.ausy.jewelry.commons.dto.ProductDTO;

/**
 * This interface represents the abstraction of product Data Access Object.
 * 
 * @author cimre
 *
 */
public interface ProductDao {
	
	ProductDTO getProductById(int productId);
	
	List<ProductDTO> getAllProduct();
	
	public void insertProduct(String productName);
	
	public void deleteProduct(int productId);

}
