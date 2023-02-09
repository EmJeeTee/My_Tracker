package com.mytracker.service;
import com.mytracker.model.Movement;
import com.mytracker.model.User;
import com.mytracker.request.MovementCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovementService {


    Movement createMovement(MovementCreateRequest newMomentRequest);

    Movement calculate(Movement movement);

    String deleteMovementById(Long movementId);

    List<Movement> getAllMovement();

    Movement getMovementById(Long movementId);
}
