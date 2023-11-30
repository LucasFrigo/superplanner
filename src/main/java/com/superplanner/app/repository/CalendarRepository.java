package com.superplanner.app.repository;

import org.springframework.stereotype.Repository;

import com.superplanner.app.model.Day;
import com.superplanner.app.model.Month;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CalendarRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Month findMonthByYearAndMonth(int year, Long month) {
        return entityManager.createQuery("SELECT m FROM Month m WHERE m.year = :year AND m.month = :month", Month.class)
                 .setParameter("year", year)
                 .setParameter("month", month)
                 .getSingleResult();
    }

    public Day findDayById(Long dayId) {
        return entityManager.find(Day.class, dayId);
    }

    public void saveDay(Day day) {
        if (day.getDayId() == null) {
             entityManager.persist(day);
         } else {
             entityManager.merge(day);
         }
    }
    
}
