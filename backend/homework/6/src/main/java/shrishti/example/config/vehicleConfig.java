package shrishti.example.config;
import shrishti.example.Logger.logBack;
import org.springframework.stereotype.Component;
import shrishti.example.beans.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class vehicleConfig {
    List<vehicleService> vehicleList;
    @PostConstruct
    public void hellow(){
        vehicleList = new ArrayList<>();
    }
    public void addToVehicleList(tyreService tyre, speakerService speaker){
        vehicleService newVehicle = new vehicleService(speaker, tyre, 2000);
       int cost = calcPrice(newVehicle);
        newVehicle.setCost(cost);
        vehicleList.add(newVehicle);
    }
    public int calcPrice(vehicleService vehicle){
        int amount = vehicle.getPriceTag() + vehicle.getTyre().getTyreCost()  + vehicle.getSpeaker().getSpeakerCost();
        logBack.infoLogger( String.valueOf(amount));

        return amount;
    }
    public void mostExpensive(){
        vehicleService expensiveVehicle = vehicleList.stream().max((v1,v2) -> Integer.compare(v1.getCost(), v2.getCost())).orElse(null);
        assert expensiveVehicle != null;
        logBack.infoLogger("expensive vehicle speaker: " + expensiveVehicle.getSpeaker().getSpeakerCost());
        logBack.infoLogger("expensive vehicle tyre: "  + expensiveVehicle.getTyre().getTyreCost());
        logBack.infoLogger("expensive vehicle cost: " + expensiveVehicle.getCost());
    }

}
