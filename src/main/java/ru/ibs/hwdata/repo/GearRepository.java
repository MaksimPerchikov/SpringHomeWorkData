package ru.ibs.hwdata.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.ibs.hwdata.entities.Gear;

import javax.persistence.criteria.CriteriaBuilder;

public interface GearRepository extends JpaRepository<Gear, Integer> {
}
