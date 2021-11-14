package ru.ibs.hwdata.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ibs.hwdata.dao.CarDAO;
import ru.ibs.hwdata.entities.Car;
import ru.ibs.hwdata.entities.Engine;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/car")
public class CarController {

    @Autowired
    private  CarDAO carDAO;


    @GetMapping(value = "read/{id}", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> readById(@PathVariable("id") Integer id) {  //List<Car> --> Object
        try {
            List<Car> engineList = new ArrayList<>();
            engineList.add((Car) carDAO.findById(id));
            return engineList;
        } catch (Exception e) {
            return carDAO.findAll();
        }
    }

    @PostMapping(value = "create", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Car create(@RequestBody Car car) {
        return carDAO.save(car);
    }


    @GetMapping(value = "delete/{id}", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") Integer id) {
        try {
            carDAO.deleteById(id);
        } catch (Exception e) {
            new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Апдейт нужно доделать!
    @PostMapping("update/{id}")
    public void updateById(@RequestBody Integer id,
                           Car car) {
        try {
            //   Car carModified = carDAO.findById(id);
            //  carDAO.save(carModified);
        } catch (Exception e) {
            new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

















