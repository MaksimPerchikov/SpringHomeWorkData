package ru.ibs.hwdata.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ibs.hwdata.dao.EngineDAO;
import ru.ibs.hwdata.entities.Engine;

import java.util.List;

@RestController
@RequestMapping("/api/engine")
public class EngineController {


    private final EngineDAO engineDAO;
    @Autowired
    public EngineController(EngineDAO engineDAO) {
        this.engineDAO = engineDAO;
    }



    @GetMapping(value = "read/{id}", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object readById(@PathVariable("id") Integer id) {  //List<Car> --> Object
        List<Engine> engineListList = engineDAO.findAll();
        return engineListList.stream()
                .filter(engine -> {
                    return engine.getId_engine().equals(id);
                })
                .findFirst();
    }

    @GetMapping(value="read" ,consumes ={MediaType.ALL_VALUE},produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Engine> readAll(){
        return engineDAO.findAll();
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


    @PostMapping(value = "update/{id}", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateById(@PathVariable("id") Integer id,@RequestBody Engine engine) {
        try {
            engineDAO.deleteById(id);
            engineDAO.save(engine);
        } catch (Exception e) {
            new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
