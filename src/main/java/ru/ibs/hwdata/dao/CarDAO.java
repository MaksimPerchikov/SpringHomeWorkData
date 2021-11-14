package ru.ibs.hwdata.dao;


import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.ibs.hwdata.entities.Car;
import ru.ibs.hwdata.entities.Engine;
import ru.ibs.hwdata.repo.CarRepository;

import java.util.List;
import java.util.Optional;

@Component
public class CarDAO {

    CarRepository carRepository;

    /*CarDAO(CarRepository carRepository){
        this.carRepository = carRepository;
    }
*/
    public Car save(Car car){
        return carRepository.save(car);
    }

    public List<Car> findAll(){
        return carRepository.findAll();
    }

   public Object findById(Integer id){
       return carRepository.findById(id);
   }

    public void deleteById(Integer id){
        carRepository.deleteById(id);
    }


    //тестовый гет метод
    public String str(){
        return "lala";
    }
    public String strP(String str1){
        return str1;
    }


}
