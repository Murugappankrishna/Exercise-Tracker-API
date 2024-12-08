package com.murugappan.Exercise.Tracker.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String userName;
    String description;
    String duration;
    LocalDate date;
    @ManyToOne()
    User user;
}
