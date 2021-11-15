package ru.ibs.hwdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ibs.hwdata.dao.GearDAO;
import ru.ibs.hwdata.entities.Car;
import ru.ibs.hwdata.entities.Engine;
import ru.ibs.hwdata.entities.Gear;
import ru.ibs.hwdata.repo.GearRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/gear")
public class GearController {


    private final GearDAO gearDAO;
    @Autowired
    public GearController(GearDAO gearDAO) {
        this.gearDAO = gearDAO;
    }

    @GetMapping(value = "read/{id}", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Gear> readById(@PathVariable("id") Integer id) {
        try {
            List<Gear> engineList = new ArrayList<>();
            engineList.add((Gear) gearDAO.findById(id));
            return engineList;

        } catch (Exception e) {
            return gearDAO.findAll();
        }
    }

    @PostMapping(value = "create", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Gear create(@RequestBody Gear gear) {
        return gearDAO.save(gear);
    }

    @GetMapping(value = "delete/{id}", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") Integer id) {
        try {
            gearDAO.deleteById(id);
        } catch (Exception e) {
            new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("update/{id}")
    public void updateById(@RequestBody Integer id,
                           Gear gear) {
        try {
            Map<Gear, Integer> gearIntegerMap = new HashMap<>();
            gearIntegerMap.put(gear, id);
        } catch (Exception e) {
            new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
