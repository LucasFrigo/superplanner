package com.superplanner.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superplanner.app.model.Day;
import com.superplanner.app.model.Month;
import com.superplanner.app.repository.DayRepository;
import com.superplanner.app.repository.MonthRepository;
import com.superplanner.app.repository.ReminderRepository;

@Service
@Transactional
public class CalendarService {

    @Autowired
    private final MonthRepository monthRepository;

    @Autowired
    private final DayRepository dayRepository;

    @Autowired
    private final ReminderRepository reminderRepository;
    

    public CalendarService(MonthRepository calendarRepository, DayRepository dayRepository, ReminderRepository reminderRepository) {
        this.monthRepository = calendarRepository;
        this.dayRepository = dayRepository;
        this.reminderRepository = reminderRepository;
    }

    public Month getMonth(int year, Long monthId) {
        return monthRepository.findByYearAndMonth(year, monthId);
    }

    public Day getDayById(Long dayId) {
        return dayRepository.findByDayId(dayId);
    }

    public void addReminder(Day day, String reminderTime, String reminderDescription) {
        day.addReminder(reminderTime, reminderDescription);
        monthRepository.save(day.getMonth());
        dayRepository.save(day);
        reminderRepository.saveAll(day.getReminders());
    }

    public void removeReminder(Day day, String reminderId) {
        day.removeReminder(reminderId);
        monthRepository.save(day.getMonth());
    }

    public Month getOrCreateMonth(int year, Long month) {
        Month existingMonth = monthRepository.findByYearAndMonth(year, month);

        if (existingMonth == null) {
            existingMonth = new Month();
            existingMonth.setYear(year);
            existingMonth.setMonthId(month);
            monthRepository.save(existingMonth);
        }
        return existingMonth;
    }

    
}
