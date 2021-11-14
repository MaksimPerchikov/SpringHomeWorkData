package ru.ibs.hwdata.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.ibs.hwdata.entities.Gear;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface GearRepository extends JpaRepository<Gear, Integer> {
}
