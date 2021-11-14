package ru.ibs.hwdata.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.hwdata.entities.Manual;

import javax.persistence.criteria.CriteriaBuilder;

public interface ManualRepository extends JpaRepository<Manual,Integer> {
}
