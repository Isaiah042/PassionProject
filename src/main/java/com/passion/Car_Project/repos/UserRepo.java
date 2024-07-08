package com.passion.Car_Project.repos;

import com.passion.Car_Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
