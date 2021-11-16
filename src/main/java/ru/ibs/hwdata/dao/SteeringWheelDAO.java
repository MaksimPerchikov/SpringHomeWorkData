package ru.ibs.hwdata.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.hwdata.entities.SteeringWheel;
import ru.ibs.hwdata.repository.SteeringWheelRepository;

import java.util.List;

@Service
public class SteeringWheelDAO {

    SteeringWheelRepository steeringWheelRepository;

    @Autowired
    public SteeringWheelDAO(SteeringWheelRepository steeringWheelRepository) {
        this.steeringWheelRepository = steeringWheelRepository;
    }

    public SteeringWheel save(SteeringWheel steeringWheel){
        return steeringWheelRepository.save(steeringWheel);
    }

    public List<SteeringWheel> findAll(){
        return steeringWheelRepository.findAll();
    }

    public Object findById(Integer id){
        return steeringWheelRepository.findById(id);
    }

    public void deleteById(Integer id){
        steeringWheelRepository.deleteById(id);
    }

    public void updateById(SteeringWheel steeringWheel){
        steeringWheelRepository.save(steeringWheel);
    }
}
