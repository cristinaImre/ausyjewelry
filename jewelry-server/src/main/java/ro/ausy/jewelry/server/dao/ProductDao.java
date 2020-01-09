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
	
	ProductDTO getProductById(long productId);
	
	List<ProductDTO> getAllProduct();
	
	void insertProduct(ProductDTO productDTO);
	
	void deleteProduct(ProductDTO productDTO);
}
