package ru.ibs.hwdata.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ibs.hwdata.dao.SteeringWheelDAO;
import ru.ibs.hwdata.entities.SteeringWheel;

@RestController
@RequestMapping("/api/steeringWheel")
public class SteeringWheelController {


    private final SteeringWheelDAO steeringWheelDAO;
    @Autowired
    public SteeringWheelController(SteeringWheelDAO steeringWheelDAO) {
        this.steeringWheelDAO = steeringWheelDAO;
    }

    @GetMapping(value = "read/{id}", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object readById(@PathVariable("id") Integer id) {
        return steeringWheelDAO.findById(id);
    }

    @PostMapping(value = "create", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public SteeringWheel create(@RequestBody SteeringWheel steeringWheel) {
        return steeringWheelDAO.save(steeringWheel);
    }

    @GetMapping(value = "delete/{id}", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") Integer id) {
        try {
            steeringWheelDAO.deleteById(id);
        } catch (Exception e) {
            new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "update/{id}", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateById(@PathVariable("id") Integer id,@RequestBody SteeringWheel steeringWheel) {
        try {
            steeringWheelDAO.deleteById(id);
            steeringWheelDAO.save(steeringWheel);
        } catch (Exception e) {
            new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
