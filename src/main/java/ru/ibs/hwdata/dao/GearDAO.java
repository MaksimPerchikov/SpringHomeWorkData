package ru.ibs.hwdata.dao;

import org.springframework.stereotype.Service;
import ru.ibs.hwdata.entities.Engine;
import ru.ibs.hwdata.entities.Gear;
import ru.ibs.hwdata.repo.EngineRepository;
import ru.ibs.hwdata.repo.GearRepository;

import java.util.List;

@Service
public class GearDAO {

    private GearRepository gearRepository;

    public Gear save(Gear gear){
        return gearRepository.save(gear);
    }

    public List<Gear> findAll(){
        return gearRepository.findAll();
    }

    public Gear findById(Integer id){
        return gearRepository.getOne(id);
    }

    public void deleteById(Integer id){
        gearRepository.deleteById(id);
    }
}
