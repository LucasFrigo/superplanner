package com.superplanner.app.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.superplanner.app.model.Day;
import com.superplanner.app.service.CalendarService;

@Controller
@RequestMapping("/calendar")
public class CalendarController {
    
    @Autowired
    private final CalendarService calendarService;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @GetMapping("/")
    public String viewCalendar() {
        return "calendar";
    }

    @GetMapping("/{year}/{month}")
    public String viewMonth(@PathVariable int year, @PathVariable Long month, Model model) {
        model.addAttribute("month", calendarService.getMonth(year, month));
        return "calendar";
    }

    @PostMapping("/addReminder")
    public String addReminder(@RequestParam Long dayId, @RequestParam String reminderTime, @RequestParam String reminderDescription) {
        Day day = calendarService.getDayById(dayId);
        calendarService.addReminder(day, reminderTime, reminderDescription);
        return "redirect:/calendar";
    }

    @PostMapping("/removeReminder")
    public String removeReminder(@RequestParam Long dayId, @RequestParam String reminderId) {
        Day day = calendarService.getDayById(dayId);
        calendarService.removeReminder(day, reminderId);
        return "redirect:/calendar";
    }

}
