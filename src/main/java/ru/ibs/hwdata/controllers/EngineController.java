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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/engine")
public class EngineController {


    private final EngineDAO engineDAO;
    @Autowired
    public EngineController(EngineDAO engineDAO) {
        this.engineDAO = engineDAO;
    }





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

    @PostMapping("update/{id}")
    public void updateById(@RequestBody Integer id,
                           Engine engine) {
        try {
            Map<Engine, Integer> engineIntegerHashMap = new HashMap<>();
            engineIntegerHashMap.put(engine, id);
        } catch (Exception e) {
            new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
