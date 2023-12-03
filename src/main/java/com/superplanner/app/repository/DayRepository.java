package com.superplanner.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.superplanner.app.model.Day;


@Repository
public interface DayRepository extends MongoRepository<Day, Long> {
    
    @Query("{ 'days.dayId' : ?0 }")
    Day findByDayId(Long dayId);
    
}
