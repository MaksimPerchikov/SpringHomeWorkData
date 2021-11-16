package ru.ibs.hwdata.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.hwdata.entities.Engine;
import ru.ibs.hwdata.repository.EngineRepository;

import java.util.List;

@Service
public class EngineDAO {

    EngineRepository engineRepository;
    @Autowired
    public EngineDAO(EngineRepository engineRepository) {
        this.engineRepository = engineRepository;
    }

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

    public void updateById(Engine engine){
        engineRepository.save(engine);
    }
}
