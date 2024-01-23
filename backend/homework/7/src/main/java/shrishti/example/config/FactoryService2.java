package shrishti.example.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import shrishti.example.Data.Inventory;
import shrishti.example.Logger.logBack;
import shrishti.example.beans.*;

import javax.annotation.PostConstruct;

@Component
public class FactoryService2 {
    @Autowired
    private Speaker speaker;
    private final Tyre tyre;
    @Autowired
    public FactoryService2(@Qualifier("BridgeStone") Tyre tyre1){
        this.tyre = tyre1;
    }
    public Inventory inventoryConfig;
    @Autowired
    public void setInventory(Inventory inventoryConfig){
        this.inventoryConfig = inventoryConfig;
    }
    @PostConstruct
    public void getVehicle() {
        int n = 3;
        for (int i = 0; i < n; i++) {
            Vehicle newVehicle = new Vehicle(speaker, tyre, (int) (Math.random() * 1001));
            logBack.infoLogger(Integer.toString(newVehicle.getPriceTag()));
            double cost = inventoryConfig.calcPrice(newVehicle);
            newVehicle.setCost(cost);
            inventoryConfig.addVehicleToLIst(newVehicle);

        }

    }
}
