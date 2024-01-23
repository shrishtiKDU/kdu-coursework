package shrishti.example.Data;
import org.springframework.stereotype.Component;
import shrishti.example.beans.Vehicle;
import java.util.*;

@Component
public class Inventory {
       private List<Vehicle>vehicleList = new ArrayList<Vehicle>();
        public void addVehicleToLIst(Vehicle vehicle){
          vehicleList.add(vehicle);
        }

        public List<Vehicle> getVehicle(){
             return vehicleList;
        }
        public Vehicle highestVehicle(){
            return vehicleList.stream().max((v1,v2) -> Double.compare(v1.getCost(), v2.getCost())).orElse(null);
        }
    public Vehicle lowestVehicle(){
       return vehicleList.stream().min((v1,v2) -> Double.compare(v1.getCost(), v2.getCost())).orElse(null);
    }

    public double calcPrice(Vehicle vehicle){
        return  vehicle.getCost()+vehicle.getPriceTag() + vehicle.getSpeaker().getSpeakerCost() + vehicle.getTyre().getTyreCost();
    }



}
