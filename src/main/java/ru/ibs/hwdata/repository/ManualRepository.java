package ru.ibs.hwdata.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ibs.hwdata.entities.Manual;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface ManualRepository extends JpaRepository<Manual,Integer> {
}
