package com.superplanner.app.model;

import java.util.List;

import lombok.Data;

@Data
public class Month {
    
    /*
     * Serve como o numero do mes tambem
     * Ex: se o mes for abril, o id = 4
     */
    private int id;
    private int year;
    private List<Day> days;


}
