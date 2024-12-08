package com.murugappan.Exercise.Tracker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserExerciseLogsDto {
    @JsonProperty("_id")
    String id;
    @JsonProperty("username")
    String userName;
    @JsonProperty("count")
    Integer Count;
    @JsonProperty("log")
    List<LogDto> log;

}
