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
public class Gear {

    @Id
    @GeneratedValue
    private Integer id_gear;

    private String typeGear;

    @Override
    public String toString() {
        return "Gear{" +
                "id=" + id_gear +
                ", typeGear='" + typeGear + '\'' +
                '}';
    }
}
