package ro.ausy.jewelry.server.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ro.ausy.jewelry.commons.dto.ProductDTO;
import ro.ausy.jewelry.server.business.ProductManager;
import ro.ausy.jewelry.server.dao.ProductDao;
import ro.ausy.jewelry.server.entity.Product;

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
	public void insertProduct(ProductDTO productDTO) {
		productDao.insertProduct(productDTO);
	}
	
	@Override
	public void deleteProduct(ProductDTO productDTO) {
		productDao.deleteProduct(productDTO);
	}
	

	public List<ProductDTO> listDTO() {
		List<Product> list = productDao.displayProduct();
		List<ProductDTO> listDTO = new ArrayList<ProductDTO>();
		for(Product product : list) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductDTOId(product.getProductId());
			productDTO.setProductName(product.getProductName());
			listDTO.add(productDTO);
		}
		return listDTO;
	}

}
