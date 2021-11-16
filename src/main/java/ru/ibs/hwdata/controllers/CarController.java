package ru.ibs.hwdata.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ibs.hwdata.dao.CarDAO;
import ru.ibs.hwdata.entities.Car;

import java.util.List;


@RestController
@RequestMapping("/api/car")
public class CarController {

    private final CarDAO carDAO;

    @Autowired
    public CarController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping(value = "read/{id}", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object readById(@PathVariable("id") Integer id) {  //List<Car> --> Object
        List<Car> carList = carDAO.findAll();
        return carList.stream()
                .filter(car -> {
                    return car.getId().equals(id);
                })
                .findFirst();
        //Или просто вот так сделать.
        /*return carDAO.findById(id);*/

    }

    @GetMapping(value = "read", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> readAll() {
        return carDAO.findAll();
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


    @PostMapping(value = "update/{id}", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateById(@PathVariable("id") Integer id,@RequestBody Car car) {
        try {
            carDAO.deleteById(id);
            carDAO.save(car);
        } catch (Exception e) {
            new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

















