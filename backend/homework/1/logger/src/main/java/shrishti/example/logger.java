package shrishti.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class logger {

    static Logger log= LoggerFactory.getLogger(logger.class);

    public static void logaddmsg(String s, student newStudent) {
        log.info(s,newStudent);
    }

    public void logmsg(String msg){
        log.debug(msg);
    }
}
