package reusableComponents;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility class for logging using Log4j2.
 */
public class LoggerUtils {
	private static Logger getLogger() {
        // Get the caller class (the real origin of the log)
        String className = Thread.currentThread().getStackTrace()[3].getClassName();
        return LogManager.getLogger(className);
    }
    /**
     * Logs an info message.
     *
     * @param message The message to log.
     */
    public static void info(String message) {
    	getLogger().info(message);
    }

    /**
     * Logs a warning message.
     *
     * @param message The message to log.
     */
    public static void warn(String message) {
    	getLogger().warn(message);
    }

    /**
     * Logs an error message.
     *
     * @param message The message to log.
     */
    public static void error(String message) {
        getLogger().error(message);
    }

    /**
     * Logs an error message with an associated throwable.
     *
     * @param message The message to log.
     * @param t       The throwable to log.
     */
    public static void error(String message, Throwable t) {
        getLogger().error(message, t);
    }
}