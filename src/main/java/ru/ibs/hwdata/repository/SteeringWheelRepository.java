package ru.ibs.hwdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ibs.hwdata.entities.SteeringWheel;

@Repository
public interface SteeringWheelRepository extends JpaRepository<SteeringWheel,Integer> {
}
