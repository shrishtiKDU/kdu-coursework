package shrishti.example.demo.Controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shrishti.example.demo.DTO.VehicleDto;

import shrishti.example.demo.Entity.Vehicle;
import shrishti.example.demo.Service.VehicleService;

import java.util.List;


@RestController
@AllArgsConstructor
public class VehicleController {

    private VehicleService vehicleService;
    @PostMapping("/api/vehicle")
    public ResponseEntity<String>createVehicle(@RequestBody VehicleDto vehicle){
        vehicleService.createVehicle(vehicle);
        String message =" successfully addedd";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping("/api/vehicle/{id}")
    public Vehicle getVehicleById(@PathVariable("id") int id){
            return vehicleService.getVehicleById(id);

    }

    @GetMapping("/api/vehicle/allVehicles")
    public ResponseEntity<List<VehicleDto>>  getAllVehicle(){
        List<VehicleDto> vehicles = vehicleService.getAllVehicle();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @PutMapping("/api/vehicle/{id}")
    public ResponseEntity<String> updateVehicle(@PathVariable("id") int id, @RequestBody VehicleDto vehicle){
        vehicleService.updateVehicle(vehicle);
        String message= "updated success";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/api/vehicle/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id){
        vehicleService.deleteVehicle(id);
        return new ResponseEntity<>("User successfullt deleted", HttpStatus.OK);
    }
    @GetMapping("/api/vehicle/mostExpensive")
    public Vehicle mostExpensive(){
        return vehicleService.mostExpensive();
    }

    @GetMapping("/api/vehicle/leastExpensive")
    public Vehicle leastExpensive(){
        return vehicleService.leastExpensive();
    }

}

