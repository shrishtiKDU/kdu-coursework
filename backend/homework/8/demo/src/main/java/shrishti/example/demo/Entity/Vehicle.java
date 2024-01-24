package shrishti.example.demo.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Vehicle {
   private String brandName;
   private String color;
   private int id;
   private int manufactureCost;

}
