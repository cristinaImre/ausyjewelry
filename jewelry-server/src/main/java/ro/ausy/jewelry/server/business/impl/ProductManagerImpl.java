package ro.ausy.jewelry.server.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import ro.ausy.jewelry.commons.dto.ProductDTO;
import ro.ausy.jewelry.server.business.ProductManager;
import ro.ausy.jewelry.server.dao.ProductDao;
import ro.ausy.jewelry.server.dao.UserDao;

/**
 * This class represents a manager that implements the methods from
 * <code>ProductManager</code> interface.
 * 
 * @author cimre
 *
 */
@Repository
public class ProductManagerImpl implements ProductManager {

	final ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	ProductDao productDao = appContext.getBean(ProductDao.class);
	
	@Override
	public ProductDTO getProductById(int productId) {
		return productDao.getProductById(productId);
	}
	
	@Override
	public List<ProductDTO> getAllProduct() {
		return productDao.getAllProduct();
	}
	
	@Override
	public void insertProduct(ProductDTO productDTO) {
		productDao.insertProduct(productDTO);
	}
	
	@Override
	public void deleteProduct(ProductDTO productDTO) {
		productDao.deleteProduct(productDTO);
	}

}
