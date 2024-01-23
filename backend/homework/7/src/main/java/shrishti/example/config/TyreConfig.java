package shrishti.example.config;
import org.springframework.context.annotation.Configuration;
import  shrishti.example.beans.*;
import org.springframework.context.annotation.Bean;

@Configuration
public class TyreConfig {
    @Bean(name = "MRF")
    Tyre tyre1() {
        Tyre tyre = new Tyre();
        tyre.setTyreName("MRF");
        tyre.setTyreCost(20);
        return tyre;
    }
    @Bean(name = "BridgeStone")
    Tyre tyre2() {
        Tyre tyre = new Tyre();
        tyre.setTyreName("BridgeStone");
        tyre.setTyreCost(30);
        return tyre;
    }

}
