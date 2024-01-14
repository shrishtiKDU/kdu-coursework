package shrishti.example.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class logger {
    private static final Logger logger
            = LoggerFactory.getLogger(logger.class);


    public static void printOutput(String message) {
        logger.info(message);
    }
    public static void printMessage(String message) {

        logger.info(message);
    }

}

