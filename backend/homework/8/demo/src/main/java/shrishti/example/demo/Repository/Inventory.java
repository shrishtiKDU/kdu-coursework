package shrishti.example.demo.Repository;

import lombok.Data;

import shrishti.example.demo.Entity.Vehicle;

import java.util.ArrayList;
import java.util.List;

@Data
public class Inventory {
private List<Vehicle>vehicles  = new ArrayList<>();
public void save(Vehicle vehicle){
    this.vehicles.add(vehicle);
}
public Vehicle findById(int id){
    return vehicles.get(id);
}

public void updateVehicle(int id, Vehicle vehicle){
    vehicles.get(id).setBrandName(vehicle.getBrandName());
    vehicles.get(id).setManufactureCost(vehicle.getManufactureCost());
}
public void deleteById(int id){
    vehicles.remove(id);
}
public Vehicle mostExpensive(){
    Vehicle mostExpensive = vehicles.get(0);
    for(int i=1; i<vehicles.size();i++){
        Vehicle currenVehicle = vehicles.get(i);
        if(currenVehicle.getManufactureCost() > mostExpensive().getManufactureCost()){
            mostExpensive = currenVehicle;
        }
    }
    return mostExpensive;
}

public Vehicle leastExpensive(){
    Vehicle leastExpensive = vehicles.get(0);
    for(int i=1;i<vehicles.size();i++){
        Vehicle currentVehicle = vehicles.get(i);
        if(currentVehicle.getManufactureCost() < leastExpensive.getManufactureCost()){
            leastExpensive = currentVehicle;
        }
    }
    return leastExpensive;
}

}
