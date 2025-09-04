package commonClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogClass {

    private static Logger getLoggerForCaller() {
        String className = Thread.currentThread().getStackTrace()[3].getClassName();
        return LogManager.getLogger(className);
    }

    public static void info(String message) {
        getLoggerForCaller().info(message);
    }

    public static void warn(String message) {
        getLoggerForCaller().warn(message);
    }

    public static void error(String message) {
        getLoggerForCaller().error(message);
    }
    
    public static void debug(String message) {
        getLoggerForCaller().debug(message);
    }

    public static void fnWritelog(Exception excepmsg) {
        Logger log = getLoggerForCaller();
        log.error("Exception Message: {}", excepmsg.getMessage());
        log.error("Exception Class: {}", excepmsg.getClass().getName());
        for (StackTraceElement element : excepmsg.getStackTrace()) {
            log.error("at {}", element.toString());
        }
    }
}

