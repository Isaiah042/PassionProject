package com.passion.Car_Project.repos;

import com.passion.Car_Project.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepo extends JpaRepository<Part,Long> {
}
