package com.example.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Component
public class VehicleTasks {

    RestTemplate template = new RestTemplate();
    String[] makeAndModel = {"Ford Fusion", "Nissan Altima", "Toyota Camry", "Dodge Ram", "Chevorlet Camero "};
    Random rand = new Random();
    int maxYear = 2016;
    int minYear = 1986;
    int maxPrice = 45000;
    int minPrice = 15000;

    @Scheduled(cron = "*/2 * * * * *")
    public void addVehicle(){
        String url = "http://localhost:8080/addvehicle";
        template.postForObject(url, new Vehicle(makeAndModel[rand.nextInt(makeAndModel.length)],
                rand.nextInt((maxYear - minYear) + 1) + minYear,
                rand.nextInt((maxPrice - minPrice) + 1) + minPrice),
                Vehicle.class);
        System.out.println("Vehicle Added...");
    }

    @Scheduled(cron="9/10 * * * * *")
    public void deleteVehicle(){
        String url = "http://localhost:8080/deletevehicle/{id}";
        template.delete(url,rand.nextInt(rand.nextInt(40)+40));
        System.out.println("Vehicle Deleted...");
    }

    @Scheduled(cron = "7/10 * * * * *")
    public void updateVehicle(){
        String url = "http://localhost:8080/updatevehicle";
        Vehicle vehicle = new Vehicle(makeAndModel[rand.nextInt(makeAndModel.length)]+" *UPDATED*",
                rand.nextInt((maxYear - minYear) + 1) + minYear,
                rand.nextInt((maxPrice - minPrice) + 1) + minPrice);
        vehicle.setId(rand.nextInt(40)+40);
        template.put(url, vehicle, Vehicle.class);
        System.out.println("Vehicle Updated...");
    }
}
