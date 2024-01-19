package shrishti.example.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class logger {
    private static final Logger logger
            = LoggerFactory.getLogger(logger.class);


    public static void printOutput(String message, int info) {

       switch (info){
           case 1: logger.info(message);
           break;
           case 2: logger.debug(message);
           break;
           case 3: logger.error(message);
           break;
       }


    }

}

