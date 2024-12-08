package com.murugappan.Exercise.Tracker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @JsonProperty("_id")
    Integer id;
    @JsonProperty("username")
    String user;
}
