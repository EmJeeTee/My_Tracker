package com.mytracker.controller;

import com.mytracker.dto.MovementDto;
import com.mytracker.dto.UserDto;
import com.mytracker.model.Movement;
import com.mytracker.model.User;
import com.mytracker.repository.MovementRepository;
import com.mytracker.request.MovementCreateRequest;
import com.mytracker.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movement")
@CrossOrigin
public class MovementController {

    @Autowired
    private MovementService movementService;

    @Autowired
    private MovementRepository movementRepository;

    @PostMapping("/add")
    public ResponseEntity<Void> createMovement(@RequestBody MovementCreateRequest newMovement)
    {
        Movement movement = movementService.createMovement(newMovement);
        if(movement != null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/getAll")
    public List<MovementDto> getAllMovement(){
        return movementService.getAllMovement().stream().map(u -> new MovementDto(u)).toList();
    }

    @GetMapping("/{movementId}")
    public MovementDto getMovementById(@PathVariable("userId")Long movementId){
        Movement movement= movementService.getMovementById(movementId);
        return new MovementDto(movement);
    }

    @DeleteMapping("/{movementId}")
    public String deleteMovementById(@PathVariable("movementId") Long movementId){ return movementService.deleteMovementById(movementId);}
}
