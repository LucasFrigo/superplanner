package com.superplanner.app.model;

import java.util.UUID;

import lombok.Data;

@Data
public class Reminder {

    private UUID uuid;
    private String reminderTime;
    private String reminderDescription;


}
