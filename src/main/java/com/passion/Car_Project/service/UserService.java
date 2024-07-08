package com.passion.Car_Project.service;

import com.passion.Car_Project.model.User;
import com.passion.Car_Project.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User createAnAccount(User user){
        return userRepo.save(user);
    }

    public User getUserById(Long userId){
        User user = userRepo.findById(userId).orElse(null);
        return user;
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public void deleteUserById(Long userId){
        userRepo.deleteById(userId);
    }

    public User updateUser(Long userId,User updatedUser){
        User user = userRepo.findById(userId).orElse(null);
        user.setName(updatedUser.getName());
        user.setCars(updatedUser.getCars());
        return userRepo.save(updatedUser);
    }
}
