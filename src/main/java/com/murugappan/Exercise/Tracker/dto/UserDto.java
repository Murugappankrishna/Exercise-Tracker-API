package com.murugappan.Exercise.Tracker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @JsonProperty("username")
    String user;
    @JsonProperty("_id")
    String id;
}
