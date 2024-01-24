package shrishti.example.demo.Service;

import shrishti.example.demo.DTO.VehicleDto;
import shrishti.example.demo.Entity.Vehicle;
import shrishti.example.demo.Mapper.VehicleMapper;
import shrishti.example.demo.Repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {
   private Inventory inventory = new Inventory();


    @Override
    public void createVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = VehicleMapper.mapToVehicle(vehicleDto);
        inventory.save(vehicle);
    }

    @Override
    public Vehicle getVehicleById(int id) {
        Optional<Vehicle> vehicleException = Optional.ofNullable(inventory.findById(id));
         Vehicle vehicle = vehicleException.get();
         return vehicle;
    }

    @Override
    public List<VehicleDto> getAllVehicle() {
       List<Vehicle> vehicles = inventory.getVehicles();
       return vehicles.stream().map(VehicleMapper::mapToVehicleDTO).collect(Collectors.toList());
    }

    @Override
    public void updateVehicle(VehicleDto vehicle) {
       Vehicle existingVehicle = inventory.findById(vehicle.getId());
       existingVehicle.setId(vehicle.getId());
       existingVehicle.setColor(vehicle.getColor());
       existingVehicle.setBrandName(vehicle.getBrandName());
       existingVehicle.setManufactureCost(vehicle.getManufactureCost());
       inventory.save(existingVehicle);
    }

    @Override
    public void deleteVehicle(int id) {
     inventory.deleteById(id);
    }

    @Override
    public Vehicle mostExpensive() {
        return inventory.mostExpensive();
    }

    @Override
    public Vehicle leastExpensive() {
        return inventory.leastExpensive();
    }
}
