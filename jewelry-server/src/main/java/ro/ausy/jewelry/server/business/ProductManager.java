package ro.ausy.jewelry.server.business;

import java.util.List;

import ro.ausy.jewelry.commons.dto.ProductDTO;

/**
 * This interface represents a manager that handles product operations.
 * 
 * @author cimre
 *
 */
public interface ProductManager {
	/**
	 * @param productId
	 * 				the product unique identifier
	 * @return a <code>ProductDTO</code> object
	 * This method will return an <code>ProductDTO</code> object by ID.
	 */
	ProductDTO getProductById(int productId);
	
	/**
	 * @return
	 * This method will return all products.
	 */
	List<ProductDTO> getAllProduct();
	
	void insertProduct(ProductDTO productDTO);
	
	void deleteProduct(ProductDTO productDTO);

}
