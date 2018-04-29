package com.example.demo;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class VehicleDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Vehicle vehicle){
        entityManager.persist(vehicle);
        return;
    }

    public Vehicle getById(int id){
        return entityManager.find(Vehicle.class,id);
    }

    public List<Vehicle> getTen(int start){
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        for(int i=start;i<(start+11);i++){
            vehicles.add(entityManager.find(Vehicle.class,i));
        }
        return vehicles;
    }

    public void deleteById(int id) {
        Vehicle vehicle = entityManager.find(Vehicle.class,id);
        if (entityManager.contains(vehicle))
            entityManager.remove(vehicle);
        return;
    }

    public void update(Vehicle vehicle){
        Vehicle oldVehicle = entityManager.find(Vehicle.class,vehicle.getId());
        if (entityManager.contains(oldVehicle)){
            entityManager.merge(vehicle);
        }
        return;
    }
}
