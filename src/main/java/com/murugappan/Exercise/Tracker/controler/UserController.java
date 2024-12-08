package com.murugappan.Exercise.Tracker.controler;

import com.murugappan.Exercise.Tracker.dto.UserDto;
import com.murugappan.Exercise.Tracker.dto.UserExerciseDto;
import com.murugappan.Exercise.Tracker.dto.UserExerciseLogsDto;
import com.murugappan.Exercise.Tracker.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "*")
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
    ResponseEntity<List<UserDto>> getUser() {
        return userService.getUser();
    }

    @PostMapping("/users/{_id}/exercises")
    ResponseEntity<UserExerciseDto> postExerciseData(@PathVariable("_id") Integer id,
                                                     @RequestParam("description") String description,
                                                     @RequestParam("duration") Integer duration,
                                                     @RequestParam(value = "date", required = false) LocalDate date) {
        if (date == null) {
            date = LocalDate.now();
        }
        return userService.saveExercise(id, description, duration, date);
    }

    @GetMapping("/users/{_id}/logs")
    ResponseEntity<UserExerciseLogsDto> getUserExerciseLog(@PathVariable("_id") Integer id) {
        return userService.getUserExerciseLog(id);
    }
}
