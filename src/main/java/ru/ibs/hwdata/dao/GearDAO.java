package ru.ibs.hwdata.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.hwdata.entities.Gear;
import ru.ibs.hwdata.repository.GearRepository;

import java.util.List;

@Service
public class GearDAO {

    GearRepository gearRepository;
    @Autowired
    public GearDAO(GearRepository gearRepository) {
        this.gearRepository = gearRepository;
    }

    public Gear save(Gear gear){
        return gearRepository.save(gear);
    }

    public List<Gear> findAll(){
        return gearRepository.findAll();
    }

    public Object findById(Integer id){
        return gearRepository.findById(id);
    }

    public void deleteById(Integer id){
        gearRepository.deleteById(id);
    }

    public void updateById(Gear gear){
        gearRepository.save(gear);
    }
}
