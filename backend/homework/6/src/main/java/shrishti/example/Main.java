package shrishti.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shrishti.example.beans.speakerService;
import shrishti.example.beans.tyreService;
import shrishti.example.config.speakerConfig;
import shrishti.example.config.tyreConfig;
import shrishti.example.config.vehicleConfig;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext newContext = new AnnotationConfigApplicationContext(new Class[]{vehicleConfig.class, tyreConfig.class, speakerConfig.class});

        speakerService newSpeaker = (speakerService) newContext.getBean("Sony");
        tyreService newTyre  = (tyreService) newContext.getBean("MRF");
        vehicleConfig newVehicle = (vehicleConfig) newContext.getBean(vehicleConfig.class);
        newVehicle.addToVehicleList(newTyre, newSpeaker);

        speakerService newSpeaker2 = (speakerService) newContext.getBean("Bose");
        tyreService newTyre2  = (tyreService) newContext.getBean("BridgeStone");
        vehicleConfig newVehicle2 = (vehicleConfig) newContext.getBean(vehicleConfig.class);
        newVehicle2.addToVehicleList(newTyre2, newSpeaker2);

        speakerService newSpeaker3 = (speakerService) newContext.getBean("Sony");
        tyreService newTyre3  = (tyreService) newContext.getBean("BridgeStone");
        vehicleConfig newVehicle3 = (vehicleConfig) newContext.getBean(vehicleConfig.class);
        newVehicle3.addToVehicleList(newTyre3, newSpeaker3);

        speakerService newSpeaker4 = (speakerService) newContext.getBean("Bose");
        tyreService newTyre4  = (tyreService) newContext.getBean("MRF");
        vehicleConfig newVehicle4 = (vehicleConfig) newContext.getBean(vehicleConfig.class);
        newVehicle4.addToVehicleList(newTyre4, newSpeaker4);
        newVehicle.mostExpensive();

    }

}