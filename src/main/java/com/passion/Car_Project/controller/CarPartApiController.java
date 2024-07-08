package com.passion.Car_Project.controller;

import com.passion.Car_Project.reponse.ResponseHandler;
import com.passion.Car_Project.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/car")
public class CarPartApiController {

    @Autowired
    private PartService partService;

    @GetMapping("/part")
    public ResponseEntity<?> getPart(String partName) {
        try {
            partService.getPart(partName);
            return ResponseHandler.responseBuilder("Part found successfully", HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.responseBuilder("Part not found", HttpStatus.NOT_FOUND);
        }
    }


}
