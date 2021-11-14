package ru.ibs.hwdata.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ibs.hwdata.entities.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
}

