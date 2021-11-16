package ru.ibs.hwdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ibs.hwdata.entities.Engine;
@Repository
public interface EngineRepository extends JpaRepository<Engine,Integer> {
}
