package ru.ibs.hwdata.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SteeringWheel {

    @Id
    @GeneratedValue
    private Integer id;

    private String typeSW;

    @Override
    public String toString() {
        return "SteeringWheel{" +
                "id=" + id +
                ", typeSW='" + typeSW + '\'' +
                '}';
    }
}
