package com.murugappan.Exercise.Tracker.service;

import com.murugappan.Exercise.Tracker.dao.ExerciseDao;
import com.murugappan.Exercise.Tracker.dao.UserDao;
import com.murugappan.Exercise.Tracker.dto.UserDto;
import com.murugappan.Exercise.Tracker.model.Exercise;
import com.murugappan.Exercise.Tracker.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;
    private final ExerciseDao exerciseDao;

    UserService(UserDao userDao, ExerciseDao exerciseDao) {
        this.userDao = userDao;
        this.exerciseDao=exerciseDao;
    }

    public ResponseEntity<UserDto> saveUser(String username) {
        User user = new User();
        user.setUserName(username);
        userDao.save(user);
        User savedUser = userDao.findById(user.getId()).orElseThrow(() -> new RuntimeException("User not found"));
        UserDto SavedUserDto = new UserDto();
        SavedUserDto.setId(savedUser.getId().toString());
        SavedUserDto.setUser(savedUser.getUserName());
        return ResponseEntity.status(HttpStatus.CREATED).body(SavedUserDto);
    }

    public ResponseEntity<List<UserDto>> getUser() {
        List<User> allUser = new ArrayList<User>();
        List<UserDto> allUserDta = new ArrayList<UserDto>();
        allUser = userDao.findAll();
        for (User user : allUser) {
            UserDto Userdto = new UserDto();
            Userdto.setUser(user.getUserName());
            Userdto.setId(user.getId().toString());
            allUserDta.add(Userdto);
        }
        return ResponseEntity.ok().body(allUserDta);

    }


    public void saveExercise(Integer id,
                             String description,
                             String duration,
                             LocalDate date) {
        Exercise exercise = new Exercise();
        exercise.setDescription(description);
        exercise.setDate(date);
        exercise.setDuration(duration);
        User user = userDao.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        exercise.setUser(user);
        exerciseDao.save(exercise);


    }
}
