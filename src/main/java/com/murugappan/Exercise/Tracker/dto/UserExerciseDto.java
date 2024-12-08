package com.murugappan.Exercise.Tracker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserExerciseDto {
    @JsonProperty("_id")
    String id;
    @JsonProperty("username")
    String userName;
    @JsonProperty("date")
    String date;
    @JsonProperty("duration")
    Integer duration;
    @JsonProperty("description")
    String description;
}
