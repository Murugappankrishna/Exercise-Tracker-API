package com.murugappan.Exercise.Tracker.dao;

import com.murugappan.Exercise.Tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
}
