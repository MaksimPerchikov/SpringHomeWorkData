package ru.ibs.hwdata.entities;


import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.util.ProxyUtils;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private Integer id;

    private String model;

    @OneToOne
    Engine engine;

    @OneToOne
    SteeringWheel steeringWheel;

    public Car(){}

    public Car(String model) {
        this.model = model;
    }

    public Car(Integer id, String model) {
        this.id = id;
        this.model = model;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return String.join(id.toString(),model);  /*return String.join(" ",model);*/
    }

}