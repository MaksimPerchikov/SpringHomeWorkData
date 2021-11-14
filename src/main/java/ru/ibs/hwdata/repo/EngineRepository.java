package ru.ibs.hwdata.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ibs.hwdata.entities.Engine;

public interface EngineRepository extends JpaRepository<Engine,Integer> {
}
