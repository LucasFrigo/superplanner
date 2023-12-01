package com.superplanner.app.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superplanner.app.model.Day;
import com.superplanner.app.model.Month;
import com.superplanner.app.repository.CalendarRepository;

@Service
@Transactional
public class CalendarService {

    @Autowired
    private final CalendarRepository calendarRepository;

    public CalendarService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    public Month getMonth(int year, Long month) {
        return calendarRepository.findByYearAndMonth(year, month);
    }

    public Day getDayById(String dayId) {
        return calendarRepository.findByDayId(dayId);
    }

    public void addReminder(Day day, String reminderTime, String reminderDescription) {
        day.addReminder(reminderTime, reminderDescription);
        calendarRepository.save(day.getMonth());
    }

    public void removeReminder(Day day, String reminderId) {
        day.removeReminder(reminderId);
        calendarRepository.save(day.getMonth());
    }

    
}
