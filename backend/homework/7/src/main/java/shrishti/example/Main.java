package shrishti.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shrishti.example.beans.Vehicle;
import shrishti.example.config.*;
import shrishti.example.Logger.logBack;


public class Main {
    public static Vehicle expensiveVehicle(Vehicle v1, Vehicle v2){
          if(v1.getCost() > v2.getCost()){
              return v1;
          }
          else return v2;
    }

    public Vehicle lowestVehicle(Vehicle v1, Vehicle v2){
        if(v1.getCost() < v2.getCost()){
            return v1;
        }
        else return v2;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext newContext = new AnnotationConfigApplicationContext(MainConfig.class);
        FactoryService1 newFactory1 = newContext.getBean(FactoryService1.class);
        FactoryService2 newFactory2 = newContext.getBean(FactoryService2.class);

        Vehicle v1 = newFactory1.inventoryConfig.highestVehicle();
        Vehicle v2 = newFactory2.inventoryConfig.highestVehicle();
        Vehicle result = expensiveVehicle(v1,v2);
        Vehicle v3 = newFactory1.inventoryConfig.lowestVehicle();
        Vehicle v4 = newFactory2.inventoryConfig.lowestVehicle();
        Vehicle result2 = expensiveVehicle(v3,v4);

        logBack.infoLogger(Integer.toString(result.getPriceTag()));
        logBack.infoLogger(Integer.toString(result2.getPriceTag()));
    }

}