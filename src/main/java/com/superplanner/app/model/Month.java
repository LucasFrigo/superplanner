package com.superplanner.app.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.Data;


@Document
@Data
public class Month {
    
    @Id
    private Long monthId;

    private int year;

    @DBRef
    private List<Day> days;


}
