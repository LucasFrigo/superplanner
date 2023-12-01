package com.superplanner.app.model;

import java.util.HashSet;
import java.util.Set;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Document
@Data
public class Day {

    @Id
    private Long dayId;

    @DBRef
    private Month month;

    private Set<Reminder> reminders = new HashSet<>();

    public void addReminder(String reminderTime, String reminderDescription) {
        Reminder reminder = new Reminder();
        reminder.setReminderTime(reminderTime);
        reminder.setReminderDescription(reminderDescription);
        reminder.setDay(this);
        reminders.add(reminder);
    }

    public void removeReminder(String reminderId) {
        reminders.removeIf(reminder -> reminder.getReminderId().equals(reminderId));
    }
    
}
