package ru.ibs.hwdata.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Engine {

    @Id
    @GeneratedValue
    private Integer id_engine;

    private String type;

    @OneToMany(cascade = CascadeType.ALL)
    private Gear gear;

    @OneToOne
    Manual manual;

    public Engine(Integer id_engine,Gear gear, String type, Manual manual) {
        this.id_engine = id_engine;
        this.gear = gear;
        this.type = type;
        this.manual = manual;
    }
}

