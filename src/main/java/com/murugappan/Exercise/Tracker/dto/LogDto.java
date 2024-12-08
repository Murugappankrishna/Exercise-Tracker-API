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
public class LogDto {
    @JsonProperty("description")
    String description;
    @JsonProperty("duration")
    Integer duration;
    @JsonProperty("date")
    String date;


}
