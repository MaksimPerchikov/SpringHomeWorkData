package ru.ibs.hwdata.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.hwdata.entities.Car;
import ru.ibs.hwdata.repo.CarRepository;

import java.sql.*;
import java.util.List;
import java.util.Map;

@Service
public class CarDAO {

    private CarRepository carRepository;

    public Car save(Car car){
        return carRepository.save(car);
    }

    public List<Car> findAll(){
        return carRepository.findAll();
    }

    public Car findById(Integer id){
        return carRepository.getOne(id);
    }

    public void deleteById(Integer id){
        carRepository.deleteById(id);
    }

    /*public Map<Integer,List<Car>> updateById(Map<Integer,List<Car>> integerListMap){

    }*/


    /*private Map<String, String> getMessage(String id) {
        return messages.stream()
                .filter(message-> message.get("id").equals(id))
                .findAny().orElseThrow(NotFoundEx::new);
    }*/

    //тестовый гет метод
    public String str(){
        return "lala";
    }
    public String strP(String str1){
        return str1;
    }


}
