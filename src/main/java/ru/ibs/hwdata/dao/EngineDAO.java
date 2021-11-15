package ru.ibs.hwdata.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.ibs.hwdata.entities.Car;
import ru.ibs.hwdata.entities.Engine;
import ru.ibs.hwdata.repo.EngineRepository;

import java.util.List;

@Component
public class EngineDAO {

    EngineRepository engineRepository;


    public Engine save(Engine engine){
        return engineRepository.save(engine);
    }

    public List<Engine> findAll(){
        return engineRepository.findAll();
    }

    public Object findById(Integer id){
        return engineRepository.findById(id);
    }

    public void deleteById(Integer id){
        engineRepository.deleteById(id);
    }
}
