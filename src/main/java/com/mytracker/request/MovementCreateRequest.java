package com.mytracker.request;

import lombok.Data;

@Data
public class MovementCreateRequest {
    private Long userId;
    private Long id;
    private String movementName;
    private Integer kg;
    private Integer reps;
    private Double rpe;
    private String date;
    private Double score;
}
