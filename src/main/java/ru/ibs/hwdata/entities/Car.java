package ru.ibs.hwdata.entities;


import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue
    private Integer id;

    private String model;

    @OneToOne(cascade = CascadeType.ALL)
    Engine engine;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="id")
    SteeringWheel steeringWheel;


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
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", engine=" + engine +
                ", steeringWheel=" + steeringWheel +
                '}';
    }

}
