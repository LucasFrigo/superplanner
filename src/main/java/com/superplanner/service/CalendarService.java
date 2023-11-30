package com.superplanner.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.superplanner.app.model.Day;

@Service
public class CalendarService {

    public Object getMonth(int year, int month) {
        return null;
    }

    public Day getDayById(int dayId) {
        return null;
    }

    public void addReminder(Day day, String reminderText) {
    }

    public void removeReminder(Day day, UUID reminderId) {
    }
    
}
