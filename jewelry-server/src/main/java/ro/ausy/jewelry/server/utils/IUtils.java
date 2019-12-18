package ro.ausy.jewelry.server.utils;

/**
 * This interface define the path to several configuration files.
 */
public interface IUtils {
	/**
	 * This is the constant that represent the path to the hibernate
	 * configuration file.
	 */
	public static final String HIBERNATE_CONFIG_FILE_PATH = "/config/database/hibernate.cfg.xml";
	
	/**
	 * This is the constant that represent the path to the hibernate test
	 * configuration file.
	 */
	public static final String HIBERNATE_CONFIG_TEST_FILE_PATH = "/config/database/hibernate.cfg.xml";

}
