package ru.ibs.hwdata.dao;

import org.springframework.stereotype.Service;
import ru.ibs.hwdata.entities.Gear;
import ru.ibs.hwdata.entities.SteeringWheel;
import ru.ibs.hwdata.repo.SteeringWheelRepository;

import java.util.List;

@Service
public class SteeringWheelDAO {

    private SteeringWheelRepository steeringWheelRepository;

    public SteeringWheel save(SteeringWheel steeringWheel){
        return steeringWheelRepository.save(steeringWheel);
    }

    public List<SteeringWheel> findAll(){
        return steeringWheelRepository.findAll();
    }

    public SteeringWheel findById(Integer id){
        return steeringWheelRepository.getOne(id);
    }

    public void deleteById(Integer id){
        steeringWheelRepository.deleteById(id);
    }
}
