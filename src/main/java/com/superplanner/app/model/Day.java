package com.superplanner.app.model;

import java.util.List;

import lombok.Data;

@Data
public class Day {

    private int id;
    private String currentDay;
    private List<Reminder> reminders;
    
}
