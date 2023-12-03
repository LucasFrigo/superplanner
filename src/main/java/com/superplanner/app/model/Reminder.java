package com.superplanner.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;

@Document
@Data
public class Reminder {

    @Id
    private String reminderId;

    private String reminderTime;

    private String reminderDescription;

    @DBRef
    private Day day;
}
