package commonUtils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class RestFWLogger {
    public static void initLogger() {
        PropertyConfigurator.configure("log4j.properties");
    }

    public static Logger logger = Logger.getLogger(RestFWLogger.class.getName());

    public static void startTestCase(String sTestCaseName) {
        logger.info(sTestCaseName);
    }

    public static void endTestCase(String eTestCaseName) {
        logger.info(eTestCaseName);
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void fatal(String message) {
        logger.fatal(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }
}
