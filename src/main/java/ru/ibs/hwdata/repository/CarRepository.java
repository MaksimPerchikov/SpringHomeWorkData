package ru.ibs.hwdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ibs.hwdata.entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
}

