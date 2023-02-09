package com.mytracker.service.Impl;
import com.mytracker.exception.NotFoundException;
import com.mytracker.model.User;
import com.mytracker.repository.UserRepository;

import com.mytracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User newUser){return userRepository.save(newUser); }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException(userId.toString()));

    }

    @Override
    public String deleteUserById(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new NotFoundException(userId);
        }
        userRepository.deleteById(userId);
        return "User with id " +userId+ " has been deleted success.";
    }

    @Override
    public User updateUserById(Long userId, User newUser) {
        Optional<User> user =userRepository.findById(userId);
        if(user.isPresent()){
            User foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setUserPassword(newUser.getUserPassword());
            return userRepository.save(foundUser);
        }else
            return null;
    }
}
