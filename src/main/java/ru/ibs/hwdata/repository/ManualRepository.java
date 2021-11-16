package ru.ibs.hwdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ibs.hwdata.entities.Manual;

@Repository
public interface ManualRepository extends JpaRepository<Manual,Integer> {
}
