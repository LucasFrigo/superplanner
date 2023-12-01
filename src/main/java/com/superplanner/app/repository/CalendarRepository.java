package com.superplanner.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.superplanner.app.model.Day;
import com.superplanner.app.model.Month;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface CalendarRepository extends MongoRepository<Month, Long> {
    
    Month findByYearAndMonth(int year, Long month);
    Day findByDayId(String dayId);
    
}
