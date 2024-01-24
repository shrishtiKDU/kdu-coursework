package shrishti.example.demo.Service;

import org.springframework.stereotype.Service;
import shrishti.example.demo.DTO.VehicleDto;
import shrishti.example.demo.Entity.Vehicle;

import java.util.List;

@Service
public interface VehicleService {
    void createVehicle(VehicleDto vehicle);
    Vehicle getVehicleById(int id);
    List<VehicleDto> getAllVehicle();
    void updateVehicle (VehicleDto vehicleDto);
    void deleteVehicle(int id);
    Vehicle mostExpensive();
    Vehicle leastExpensive();
}
