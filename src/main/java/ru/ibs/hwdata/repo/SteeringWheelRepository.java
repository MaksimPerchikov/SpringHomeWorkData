package ru.ibs.hwdata.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.hwdata.entities.SteeringWheel;

public interface SteeringWheelRepository extends JpaRepository<SteeringWheel,Integer> {
}
