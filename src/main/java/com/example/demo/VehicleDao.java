package com.example.demo;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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
