package ru.ibs.hwdata.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.ibs.hwdata.dao.CarDAO;
import ru.ibs.hwdata.entities.Car;


import java.awt.*;
import java.util.List;


@RestController
@RequestMapping("/api/car")
public class CarController {

    @Autowired
    private CarDAO carDAO;

    @GetMapping(value = "show",consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> showAllCar(){
        List<Car> carList = carDAO.findAll();
       return carList;
    }

    @PostMapping(value = "create",consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Car create(Car car){
    return carDAO.save(car);
    }

    @GetMapping(value = "search/{id}",consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Car searchById(@RequestParam Integer id){
        return carDAO.findById(id);
    }

    @GetMapping(value = "delete/{id}",consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@RequestParam Integer id){
        carDAO.deleteById(id);
    }

    //Тестовый вызов
    @GetMapping("/la")
    public String ss(){
        return carDAO.str();
    }


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













