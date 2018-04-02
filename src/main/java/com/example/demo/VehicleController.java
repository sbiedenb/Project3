package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.CharEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@EnableAutoConfiguration
@RestController
public class VehicleController {

    @Autowired
    private VehicleDao vehicleDao;

    @RequestMapping(value = "/addvehicle", method = RequestMethod.POST)
    public void addVehicle(@RequestBody Vehicle newVehicle) throws IOException{
        vehicleDao.create(newVehicle);
    }

    @RequestMapping(value = "/getvehicle/{id}", method = RequestMethod.GET)
    public Vehicle getVehicle(@PathVariable("id") int id) throws IOException{
        return vehicleDao.getById(id);
    }

    @RequestMapping(value = "/updatevehicle", method = RequestMethod.PUT)
    public void updateVehicle(@RequestBody Vehicle newVehicle) throws IOException{
        vehicleDao.update(newVehicle);
    }

    @RequestMapping(value = "/deletevehicle/{id}", method = RequestMethod.DELETE)
    public void deleteVehicle(@PathVariable("id") int id) throws IOException {
        vehicleDao.deleteById(id);
    }

}
