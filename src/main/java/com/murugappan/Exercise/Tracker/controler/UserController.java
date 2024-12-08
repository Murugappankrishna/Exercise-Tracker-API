package com.murugappan.Exercise.Tracker.controler;

import com.murugappan.Exercise.Tracker.dto.UserDto;
import com.murugappan.Exercise.Tracker.model.User;
import com.murugappan.Exercise.Tracker.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/api")
@RestController
public class UserController {
    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    ResponseEntity<UserDto> createUser(@RequestParam("username") String userName) {
        return userService.saveUser(userName);
    }

    @GetMapping("/users")
    ResponseEntity<List<UserDto>>getUser() {
        return userService.getUser();
    }

    @PostMapping("/users/{_id}/exercises")
    void postExerciseData(@PathVariable("_id") Integer id,
                          @RequestParam("description") String description,
                          @RequestParam("duration") String duration,
                          @RequestParam(value = "date", required = false) LocalDate date) {
        if (date == null) {
            date = LocalDate.now();
        }
        userService.saveExercise(id,description,duration,date);
    }
}

