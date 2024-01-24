package shrishti.example.demo.Mapper;

import shrishti.example.demo.DTO.VehicleDto;
import shrishti.example.demo.Entity.Vehicle;

public class VehicleMapper {
    public static VehicleDto mapToVehicleDTO(Vehicle vehicle){
        return new VehicleDto(
                vehicle.getBrandName(),
                vehicle.getColor(),
                vehicle.getId(),
                vehicle.getManufactureCost()

        );
    }

    public static Vehicle mapToVehicle(VehicleDto vehicleDto){
        return new Vehicle(
                vehicleDto.getBrandName(),
                vehicleDto.getColor(),
                vehicleDto.getId(),
                vehicleDto.getManufactureCost()
                );
    }
}

