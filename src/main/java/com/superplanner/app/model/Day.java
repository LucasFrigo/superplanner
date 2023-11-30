package com.superplanner.app.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;


@Entity
@Data
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dayId;

    @ManyToOne
    @JoinColumn(name = "month_id")
    private Month month;

    @OneToMany(mappedBy = "day", cascade = CascadeType.ALL, orphanRemoval = true)
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
