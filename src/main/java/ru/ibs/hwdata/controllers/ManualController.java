package ru.ibs.hwdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ibs.hwdata.dao.ManualDAO;
import ru.ibs.hwdata.entities.Manual;

@RestController
@RequestMapping("/api/manual")
public class ManualController {

    private final ManualDAO manualDAO;
    @Autowired
    public ManualController(ManualDAO manualDAO) {
        this.manualDAO = manualDAO;
    }

    @GetMapping(value = "read/{id}", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object readById(@PathVariable("id") Integer id) {
        return manualDAO.findById(id);
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
    @PostMapping(value = "update/{id}", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateById(@PathVariable("id") Integer id,@RequestBody Manual manual) {
        try {
            manualDAO.deleteById(id);
            manualDAO.save(manual);
        } catch (Exception e) {
            new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
