package shrishti.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehicleDto {
    private String brandName;
    private String color;
    private int id;
    private int manufactureCost;

}
