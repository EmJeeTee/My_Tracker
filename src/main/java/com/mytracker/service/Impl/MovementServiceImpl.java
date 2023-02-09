package com.mytracker.service.Impl;
import com.mytracker.exception.NotFoundException;
import com.mytracker.model.Calculate;
import com.mytracker.model.Movement;
import com.mytracker.model.User;
import com.mytracker.repository.MovementRepository;
import com.mytracker.request.MovementCreateRequest;
import com.mytracker.service.MovementService;
import com.mytracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovementServiceImpl implements MovementService {

    @Autowired
    private MovementRepository movementRepository;

    @Autowired
    private UserService userService;

    @Override
    public Movement createMovement(MovementCreateRequest newMomentRequest) {
        User userId = userService.getUserById(newMomentRequest.getUserId());
        if(userId==null)
            return null;
        Movement newMovement = new Movement();
        newMovement.setUser(userId);
        newMovement.setId(newMomentRequest.getId());
        newMovement.setMovementName(newMomentRequest.getMovementName());
        newMovement.setReps(newMomentRequest.getReps());
        newMovement.setKg(newMomentRequest.getKg());
        newMovement.setRpe(newMomentRequest.getRpe());
        newMovement.setDate(newMomentRequest.getDate());
        return movementRepository.save(calculate(newMovement));
    }

    @Override
    public Movement calculate(Movement movement) {
        Calculate bum = new Calculate();
        bum.deneme();
        Double temp;
        Double tempTwo;
        temp = (Double) bum.outerMap.get(movement.getReps()).get(movement.getRpe());
        tempTwo= (Double) bum.outerMap.get(movement.getReps()).get(10.0);
        movement.setScore((Double) (movement.getKg()/temp*tempTwo));
        return movement;
    }

    @Override
    public String deleteMovementById(Long movementId){
        if (!movementRepository.existsById(movementId)) {
            throw new NotFoundException(movementId);
        }
        movementRepository.deleteById(movementId);
        return "Movement with id " +movementId+ " has been deleted success.";
    }

    @Override
    public List<Movement> getAllMovement() {
        return movementRepository.findAll();
    }

    @Override
    public Movement getMovementById(Long movementId) {
        return movementRepository.findById(movementId).orElseThrow(() -> new NotFoundException(movementId));
    }

}
