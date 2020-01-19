package ro.ausy.jewelry.server.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ro.ausy.jewelry.commons.dto.ProductDTO;
import ro.ausy.jewelry.server.dao.ProductDao;
import ro.ausy.jewelry.server.entity.Product;
import ro.ausy.jewelry.server.utils.HibernateUtils;

/**
 * This class implements the product methods that the client will be able to call through <code>ProductManager</code> object.
 * @author cimre
 */
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
	/**
	 * This is the Hibernate locale session that allows you to connect 
	 * to the database.
	 */
	private SessionFactory sessionFactory;
	
	/**
	 * The logging object.
	 */
	private static Logger LOGGER = Logger.getLogger(ProductDaoImpl.class);
	
	/**
	 * This method verify if a <code>SessionFactory</code> object exists otherwise it is generated and returned.
	 * @return a <code>SessionFactory</code> object
	 */
	public SessionFactory getSessionFactory() {
		
		if (sessionFactory == null) {
			sessionFactory = HibernateUtils.getSessionFactory();
		}
		return sessionFactory;
	}
	
	/**
	 * This method sets a Hibernate session to a local session.
	 * @param sessionFactory the Hibernate session
	 */
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void insertProduct(String productName) {
		LOGGER.info("ProductDaoImpl insertProduct(ProductDTO productDTO) has been called");
		
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		
		try { 
			tx = session.beginTransaction();
			Product product = new Product();
			product.setProductName(productName);
			session.saveOrUpdate(product);
			tx.commit();
		} catch (Exception e) {
			LOGGER.error("Error: getting product by productName failed!", e);
			e.printStackTrace();
			tx.rollback();	
		} finally {
			session.close();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(HibernateUtils.SESSION_STOP);
			}
		}
	
	}
	
	@Override
	public ProductDTO getProductById(int productId) {
		LOGGER.info("ProductDaoImpl getProductById(Long id) has been called");
		
		ProductDTO productDTO = new ProductDTO();
		Session session = getSessionFactory().openSession();
		
		try {
			Product product = (Product) session.createCriteria(Product.class).add(Restrictions.eq("id", productId)).uniqueResult();
			
			if (product!= null) {
				return product.asDTO();
			}
		} catch (Exception e) {
			LOGGER.error("Error: getting product by id failed ", e);
		} finally {
			session.close();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(HibernateUtils.SESSION_STOP);
			}
		}
		return productDTO;
	}
	
	@Override
	public List<ProductDTO> getAllProduct() {
		LOGGER.info("ProductDaoImpl getAll() has been called");
		Session session = getSessionFactory().openSession();
		final List<ProductDTO> productlist = new ArrayList<ProductDTO>();
		try {
			List<Product> products = session.createCriteria(Product.class).list();
			
			for (Product productHere : products) {
				productlist.add(productHere.asDTO());
				}
			} catch (Exception e) {
				LOGGER.error("Error: getting all products");
			} finally {
				session.close();
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(HibernateUtils.SESSION_STOP);
				}
			}
			return productlist;
		}
	
	@Override
	public void deleteProduct(int productId) {
		LOGGER.info("ProductDaoImpl deleteProduct() has been called");
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Product product = new Product();
			product.setProductId(productId);
			session.delete(product);
			tx.commit();
		} catch(Exception e) {
			LOGGER.error("Error: deleting product failed", e);
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			if(LOGGER.isDebugEnabled());
			   LOGGER.debug(HibernateUtils.SESSION_STOP);
		}
	}
}
