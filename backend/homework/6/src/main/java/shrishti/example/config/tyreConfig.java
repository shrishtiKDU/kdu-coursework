package shrishti.example.config;
import org.springframework.context.annotation.Configuration;
import  shrishti.example.beans.*;
import org.springframework.context.annotation.Bean;
import shrishti.example.beans.speakerService;

@Configuration
public class tyreConfig {
    @Bean(name = "MRF")
    tyreService tyre1() {
        tyreService tyre = new tyreService();
        tyre.setTyreName("MRF");
        tyre.setTyreCost(20);
        return tyre;
    }


    @Bean(name = "BridgeStone")
    tyreService tyre2() {
        tyreService tyre = new tyreService();
        tyre.setTyreName("BridgeStone");
        tyre.setTyreCost(30);
        return tyre;
    }

}
