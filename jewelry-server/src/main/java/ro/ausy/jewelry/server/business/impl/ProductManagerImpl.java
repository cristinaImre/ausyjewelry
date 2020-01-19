package ro.ausy.jewelry.server.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.ausy.jewelry.commons.dto.ProductDTO;
import ro.ausy.jewelry.server.business.ProductManager;
import ro.ausy.jewelry.server.dao.ProductDao;

/**
 * This class represents a manager that implements the methods from
 * <code>ProductManager</code> interface.
 * 
 * @author cimre
 *
 */
@Repository
public class ProductManagerImpl implements ProductManager {

	@Autowired
	private transient ProductDao productDao;
	
	@Override
	public ProductDTO getProductById(int productId) {
		return productDao.getProductById(productId);
	}
	
	@Override
	public List<ProductDTO> getAllProduct() {
		return productDao.getAllProduct();
	}
	
	@Override
	public void insertProduct(String productName) {
		productDao.insertProduct(productName);
	}
	
	@Override
	public void deleteProduct(int productId) {
		productDao.deleteProduct(productId);
	}

}
