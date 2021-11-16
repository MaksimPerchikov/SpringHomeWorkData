package ru.ibs.hwdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ibs.hwdata.dao.GearDAO;
import ru.ibs.hwdata.entities.Gear;

import java.util.List;

@RestController
@RequestMapping("/api/gear")
public class GearController {


    private final GearDAO gearDAO;
    @Autowired
    public GearController(GearDAO gearDAO) {
        this.gearDAO = gearDAO;
    }

    @GetMapping(value = "read/{id}", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object readById(@PathVariable("id") Integer id) {  //List<Car> --> Object
        List<Gear> gearsList = gearDAO.findAll();
        return gearsList.stream()
                .filter(car -> {
                    return car.getId_gear().equals(id);
                })
                .findFirst();
    }

    @GetMapping(value="read" ,consumes ={MediaType.ALL_VALUE},produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Gear> readAll(){
        return gearDAO.findAll();
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

    @PostMapping(value = "update/{id}", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateById(@PathVariable("id") Integer id,@RequestBody Gear gear) {
        try {
            gearDAO.deleteById(id);
            gearDAO.save(gear);
        } catch (Exception e) {
            new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
