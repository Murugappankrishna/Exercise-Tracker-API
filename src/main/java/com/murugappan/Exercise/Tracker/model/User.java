package com.murugappan.Exercise.Tracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    Integer id;
    @JsonProperty("username")
    String UserName;
    @CreatedDate
    LocalDateTime CreatedDate;
    @LastModifiedDate
    LocalDateTime UpdatedTime;
    @OneToMany(mappedBy = "user")
    List<Exercise> Exercise;
}
