package com.superplanner.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.superplanner.app.model.Day;
import com.superplanner.app.model.Month;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface CalendarRepository extends MongoRepository<Month, Long> {

    @Query("{ 'year' : ?0, 'monthId' : ?1 }")
    Month findByYearAndMonth(int year, Long monthId);
    
    @Query("{ 'days.dayId' : ?0 }")
    Day findByDayId(Long dayId);
    
}
