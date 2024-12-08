package com.murugappan.Exercise.Tracker.dao;

import com.murugappan.Exercise.Tracker.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseDao extends JpaRepository<Exercise,Integer> {
}
