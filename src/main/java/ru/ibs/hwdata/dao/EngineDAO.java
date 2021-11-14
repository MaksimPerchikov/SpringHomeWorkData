package ru.ibs.hwdata.dao;

import org.springframework.stereotype.Service;
import ru.ibs.hwdata.entities.Car;
import ru.ibs.hwdata.entities.Engine;
import ru.ibs.hwdata.repo.EngineRepository;

import java.util.List;

@Service
public class EngineDAO {

    private EngineRepository engineRepository;

    public Engine save(Engine engine){
        return engineRepository.save(engine);
    }

    public List<Engine> findAll(){
        return engineRepository.findAll();
    }

    public Engine findById(Integer id){
        return engineRepository.getOne(id);
    }

    public void deleteById(Integer id){
        engineRepository.deleteById(id);
    }
}
