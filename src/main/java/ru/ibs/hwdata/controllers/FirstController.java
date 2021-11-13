package ru.ibs.hwdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ibs.hwdata.dao.CarDAO;
import ru.ibs.hwdata.entities.Car;
import ru.ibs.hwdata.repo.CarRepository;

import java.util.*;

@RestController
@RequestMapping/*(value =*/("/api/car")/*,consumes = {MediaType.ALL_VALUE},produces = MediaType.APPLICATION_JSON_VALUE)*/
public class FirstController {


    private CarRepository carRepository;

    /*private CarDAO carDAO;

    public FirstController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }*/

    /*@GetMapping("/all")
    public List<Car> index(){
        return carDAO.index();
    }*/

   /* @GetMapping("{id}")
    public Car show(@PathVariable("id") int id){
        return carDAO.show(id);
    }
*/



    ///////////////////////////////////


    /*
    private int counter = 3;
    private List<Map<String,String>> messages = new ArrayList<Map<String,String>>(){
        {
            add(new HashMap<String,String>(){{put("id","1");
                put("text","First");}});
            add(new HashMap<String,String>(){{put("id","2");
                put("text","Second");}});
        }
    };


    @GetMapping("/postbody")
    public List<Map<String,String>> postBody(){
        return messages;
    }

    @GetMapping("/search/{id}")
    public Map<String,String> getOne(@PathVariable String id){
        return getMessage(id);
    }


    private Map<String, String> getMessage(String id) {
        return messages.stream()
                .filter(message-> message.get("id").equals(id))
                .findAny().orElseThrow(NotFoundEx::new);
    }


    @PostMapping("/create")
    public Map<String,String> create(@RequestBody Map<String,String> message){
        message.put("id",String.valueOf(counter++));

        messages.add(message);
        return message;
    }

    @PostMapping("/update/{id}")
    public Map<String,String> update(@RequestBody Map<String,String> message){
        Map<String,String> messageFromDB = getMessage(message.get("id"));
        messageFromDB.putAll(message);
        return messageFromDB;
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        Map<String,String> message = getMessage(id);
        messages.remove(message);
    }*/
}













