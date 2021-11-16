package ru.ibs.hwdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ibs.hwdata.entities.Gear;

@Repository
public interface GearRepository extends JpaRepository<Gear, Integer> {
}
