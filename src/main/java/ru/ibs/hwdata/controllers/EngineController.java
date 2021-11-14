package ru.ibs.hwdata.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ibs.hwdata.dao.EngineDAO;
import ru.ibs.hwdata.entities.Car;
import ru.ibs.hwdata.entities.Engine;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/engine")
public class EngineController {

    @Autowired
    private EngineDAO engineDAO;


    @GetMapping(value = "read/{id}", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Engine> readById(@PathVariable("id") Integer id){
        try{
            List<Engine> engineList = new ArrayList<>();
            engineList.add((Engine) engineDAO.findById(id));
            return engineList;

        }catch(Exception e){
            return engineDAO.findAll();
        }
    }

    @PostMapping(value = "create", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Engine create(@RequestBody Engine engine) {
        return engineDAO.save(engine);
    }

    @GetMapping(value = "delete/{id}", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") Integer id) {
        try{
            engineDAO.deleteById(id);
        }catch (Exception e){
            new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
