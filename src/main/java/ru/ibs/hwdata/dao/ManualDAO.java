package ru.ibs.hwdata.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.hwdata.entities.Car;
import ru.ibs.hwdata.entities.Manual;
import ru.ibs.hwdata.repo.ManualRepository;

import java.util.List;
@Service
public class ManualDAO {

    ManualRepository manualRepository;

    /*public ManualDAO(ManualRepository manualRepository) {
        this.manualRepository = manualRepository;
    }*/

    public Manual save(Manual manual){
        return manualRepository.save(manual);
    }

    public List<Manual> findAll(){
        return manualRepository.findAll();
    }

    public Object findById(Integer id){
        return manualRepository.findById(id);
    }

    public void deleteById(Integer id){
        manualRepository.deleteById(id);
    }
}
