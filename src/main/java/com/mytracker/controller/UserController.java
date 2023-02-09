package com.mytracker.controller;

import com.mytracker.dto.UserDto;
import com.mytracker.model.User;
import com.mytracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mytracker.model.Calculate;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<Void> createUser(@RequestBody User newUser)
    {
        User user = userService.createUser(newUser);
        if(user != null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/getAll")
    public List<UserDto> getAllUser(){
        return userService.getAllUser().stream().map(u -> new UserDto(u)).toList();
    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable("userId")Long userId){
        User user= userService.getUserById(userId);
        return new UserDto(user);
    }

    @DeleteMapping("/{userId}")
    public String deleteUserById(@PathVariable("userId") Long userId){
        return userService.deleteUserById(userId);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUserById(@PathVariable("userId") Long userId, @RequestBody User newUser){
        User user = userService.updateUserById(userId,newUser);
        if(user != null)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
