package com.mytracker.dto;

import com.mytracker.model.Movement;
import lombok.Data;

@Data
public class MovementDto {
    private Long id;
    private Long userId;
    private String movementName;
    private Integer kg;
    private Integer reps;
    private Double rpe;
    private String date;
    private Double score;

    public MovementDto(Movement entity)
    {
        this.id = entity.getId();
        this.userId=entity.getUser().getId();
        this.movementName=entity.getMovementName();
        this.kg=entity.getKg();
        this.rpe=entity.getRpe();
        this.date=entity.getDate();
        this.reps=entity.getReps();
        this.score=entity.getScore();
    }
}
