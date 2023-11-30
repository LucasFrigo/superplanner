package com.superplanner.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;



@Entity
@Data
public class Month {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long monthId;

    private int year;

    @OneToMany(mappedBy = "month", cascade = CascadeType.PERSIST)
    private List<Day> days;


}
