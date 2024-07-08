package com.passion.Car_Project.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.passion.Car_Project.model.Part;
import com.passion.Car_Project.repos.PartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartService {

    @Autowired
    private final RestTemplate template = new RestTemplate();

    @Autowired
    private PartRepo partRepo;

    private final String url = "https://showmetheparts.com/v1";

    public void getPart(String partId){
        String fetchedURL = url + partId;
        try{
            String json = template.getForObject(fetchedURL, String.class);

            Part part = new ObjectMapper().readValue(json, Part.class);
            partRepo.save(part);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
