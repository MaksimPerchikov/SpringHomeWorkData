package ru.ibs.hwdata.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Gear {

    @Id
    @GeneratedValue
    private Integer id;

    private String typeGear;
}
