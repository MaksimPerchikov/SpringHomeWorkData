package ru.ibs.hwdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ibs.hwdata.dao.ManualDAO;
import ru.ibs.hwdata.dao.SteeringWheelDAO;
import ru.ibs.hwdata.entities.Engine;
import ru.ibs.hwdata.entities.Gear;
import ru.ibs.hwdata.entities.Manual;
import ru.ibs.hwdata.entities.SteeringWheel;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/manual")
public class ManualController {
    @Autowired
    private ManualDAO manualDAO;


    @GetMapping(value = "read/{id}", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Manual> readById(@PathVariable("id") Integer id) {
        try {
            List<Manual> engineList = new ArrayList<>();
            engineList.add((Manual) manualDAO.findById(id));
            return engineList;

        } catch (Exception e) {
            return manualDAO.findAll();
        }
    }

    @PostMapping(value = "create", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Manual create(@RequestBody Manual manual) {
        return manualDAO.save(manual);
    }

    @GetMapping(value = "delete/{id}", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") Integer id) {
        try {
            manualDAO.deleteById(id);
        } catch (Exception e) {
            new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
