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
	
	/**
	 * @param productId
	 * 				the product unique identifier
	 * @return a <code>productDTO</code> object
	 * This method will return an <code>ProductDTO</code> object by ID.
	 */
	ProductDTO getProductById(long productId);
	
	/**
	 * @return
	 * This method will return all products.
	 */
	List<ProductDTO> getAllProduct();
	
	void insertProduct(ProductDTO productDTO);
}
