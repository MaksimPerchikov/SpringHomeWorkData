package ru.ibs.hwdata.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ibs.hwdata.dao.ManualDAO;
import ru.ibs.hwdata.dao.SteeringWheelDAO;
import ru.ibs.hwdata.entities.SteeringWheel;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/steeringWheel")
public class SteeringWheelController {

    @Autowired
    private SteeringWheelDAO steeringWheelDAO;

    @GetMapping(value = "read/{id}", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SteeringWheel> readById(@PathVariable Integer id) {
        try {
            List<SteeringWheel> steeringWheelList = new ArrayList<>();
            steeringWheelList.add(steeringWheelDAO.findById(id));
            return steeringWheelList;

        } catch (Exception e) {
            return steeringWheelDAO.findAll();
        }
    }

    @PostMapping(value = "create", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public SteeringWheel create(@RequestBody SteeringWheel steeringWheel) {
        return steeringWheelDAO.save(steeringWheel);
    }

    @GetMapping(value = "delete/{id}", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer id) {
        try {
            steeringWheelDAO.deleteById(id);
        } catch (Exception e) {
            new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
