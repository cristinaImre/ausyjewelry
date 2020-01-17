package ro.ausy.jewelry.server.dao;

import java.util.List;

import ro.ausy.jewelry.commons.dto.ProductDTO;
import ro.ausy.jewelry.server.entity.Product;

/**
 * This interface represents the abstraction of product Data Access Object.
 * 
 * @author cimre
 *
 */
public interface ProductDao {
	
	ProductDTO getProductById(long productId);
	
	List<ProductDTO> getAllProduct();
	
	public void insertProduct(String productName);
	
	public void deleteProduct(int productId);

}
