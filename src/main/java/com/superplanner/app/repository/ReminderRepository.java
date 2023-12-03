package com.superplanner.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.superplanner.app.model.Reminder;

public interface ReminderRepository extends MongoRepository<Reminder, String> {
    
}
