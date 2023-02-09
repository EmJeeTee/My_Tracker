package com.mytracker.service;
import com.mytracker.model.User;

import java.util.List;

public interface UserService {
    User createUser(User newUser);

    List<User> getAllUser();

    User getUserById(Long userId);

    String deleteUserById(Long userId);

    User updateUserById(Long userId, User newUser);

}
