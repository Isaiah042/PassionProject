package com.passion.Car_Project.controller;

import com.passion.Car_Project.model.User;
import com.passion.Car_Project.reponse.ResponseHandler;
import com.passion.Car_Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createAnAccount(@RequestBody User user) {
        try{
            userService.createAnAccount(user);
            return new ResponseEntity<>("Account created successfully", HttpStatus.CREATED);
        } catch (Exception e){
            return ResponseHandler.responseBuilder("Error Creating Account", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}/user")
    public ResponseEntity<?> getUserById(@RequestParam Long id ) {
        try {
            User user = userService.getUserById(id);
            return ResponseHandler.responseBuilder("User found successfully", HttpStatus.OK, user);
        }catch (Exception e){
            return ResponseHandler.responseBuilder("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        try {
           Iterable<User> users = userService.getAllUsers();
            return ResponseHandler.responseBuilder("Users found successfully", HttpStatus.OK, users);
        }catch (Exception e){
            return ResponseHandler.responseBuilder("Users not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id ) {
        try {
            userService.deleteUserById(id);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        }catch (Exception e){
            return ResponseHandler.responseBuilder("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        try {
            userService.updateUser(id, updatedUser);
            return ResponseHandler.responseBuilder("User updated successfully", HttpStatus.OK);
        }catch (Exception e){
            return ResponseHandler.responseBuilder("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
