package ru.ibs.hwdata.repo;

import org.springframework.data.repository.CrudRepository;
import ru.ibs.hwdata.entities.Car;


public interface CarRepository extends CrudRepository<Car,Integer> {
}
