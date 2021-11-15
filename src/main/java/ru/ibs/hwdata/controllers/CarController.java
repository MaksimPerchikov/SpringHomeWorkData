package ru.ibs.hwdata.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ibs.hwdata.dao.CarDAO;
import ru.ibs.hwdata.entities.Car;
import ru.ibs.hwdata.entities.Engine;


import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;


@RestController
@RequestMapping("/api/car")
public class CarController {

    private final CarDAO carDAO;
    @Autowired
    public CarController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

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


    @PostMapping("update/{id}")
    public void updateById(@RequestBody Integer id,
                           Car car) {
        try {
            Map<Car, Integer> carIntegerMap = new HashMap<>();
            carIntegerMap.put(car, id);
        } catch (Exception e) {
            new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

















