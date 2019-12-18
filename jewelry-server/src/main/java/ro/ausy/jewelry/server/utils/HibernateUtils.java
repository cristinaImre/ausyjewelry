package ro.ausy.jewelry.server.utils;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import ro.ausy.jewelry.server.entity.Product;
import ro.ausy.jewelry.server.entity.User;
import ro.ausy.jewelry.server.entity.UserRole;

/**
 * This class will create a database connection through Hibernate. The class
 * will instantiate two objects: - SessionFactory - AnnotationConfiguration
 * 
 * @author Cristina Imre
 */
public class HibernateUtils implements IUtils {
	/**
	 * This static variable is used to create a session that allows database
	 * connection.
	 */
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	/**
	 * The logging object.
	 */
	private static Logger logger = Logger.getLogger(HibernateUtils.class);

	/**
	 * This static variable is used to add the annotated classes and configure
	 * Hibernate.
	 */
	private static Configuration config;
	
	/**
	 * Hibernate start session message.
	 */
	public static final String SESSION_START = "Hibernate session has started.";

	/**
	 * Hibernate stop session message.
	 */
	public static final String SESSION_STOP = "Hibernate session has closed.";

	/**
	 * Hibernate start transaction message.
	 */
	public static final String TRANSACTION_START = "Transaction has started.";
	
	/**
	 * Hibernate transaction successfully commited message.
	 */
	public static final String TRANSACTION_COMMITED_SUCCESSFULLY = "Transaction"
			+ " succesfully commited.";

	/**
	 * Hibernate transaction roll back message.
	 */
	public static final String TRANSACTION_ROLLBACK = "Rollback has performed.";

	/**
	 * an empty private constructor.
	 */
	public HibernateUtils() {
		// No implementation needed
	}
	
	/**
	 * Static initialization block. This block will add the annotated classes
	 * and create a database connection with Hibernate.
	 */
	static {
		try {
			config = new Configuration().configure(IUtils.HIBERNATE_CONFIG_FILE_PATH);
			config.addAnnotatedClass(User.class);
			config.addAnnotatedClass(UserRole.class);
			config.addAnnotatedClass(Product.class);
			
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
			sessionFactory = config.buildSessionFactory(builder.build());
			
		} catch (Exception ex) {
			logger.error("Initial SessionFactory creation failed.", ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	/**
	 * This method will return the SessionFactory object.
	 * 
	 * @return the SessionFactory object.
	 */
	public static SessionFactory getSessionFactory() {

		return sessionFactory;
	}
}