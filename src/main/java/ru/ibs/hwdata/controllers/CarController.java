package ru.ibs.hwdata.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ibs.hwdata.dao.CarDAO;
import ru.ibs.hwdata.entities.Car;
import ru.ibs.hwdata.repo.CarRepository;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/car")
public class CarController {

    CarRepository carRepository;

    @Autowired
    private CarDAO carDAO;

    //Выводит все машины,для себя сделал
    @GetMapping(value = "readAll", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Car>> showAllCar() {
        try {
            List<Car> list = carRepository.findAll();

            if (list.isEmpty() || list.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "read/{id}", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> readById(@PathVariable Integer id){
        try{
            List<Car> carList = new ArrayList<>();
            carList.add(carDAO.findById(id));
            return carList;

        }catch(Exception e){
            return carDAO.findAll();
        }
    }

    @PostMapping(value = "create", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Car create(@RequestBody Car car) {
        return carDAO.save(car);
    }


    //вроде изначальная версия метода readById.
    @GetMapping(value = "search/{id}", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Car searchById(@PathVariable Integer id) {
        return carDAO.findById(id);
    }

    @GetMapping(value = "delete/{id}", consumes = {MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer id) {
        try{
             carDAO.deleteById(id);
        }catch (Exception e){
            new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    //Апдейт нужно доделать!
    @PostMapping("update/{id}")
    public void updateById(@RequestBody Integer id,
                                Car car){
        try{
            Car carModified = carDAO.findById(id);
            carDAO.save(carModified);
        }catch (Exception e){
            new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //Тестовые вызовы
    @GetMapping("/la")
    public String ss() {
        return carDAO.str();
    }

    @GetMapping("laP/{str}")
    public String ssp(@PathVariable String str) {
        return carDAO.strP(str);
    }

    @PostMapping("/carss")
    public ResponseEntity<Car> saveCustomer(@RequestBody Car car) {
        try {
            return new ResponseEntity<>(carRepository.save(car), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
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

    @GetMapping("/postBody")
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
    }

}
*/













