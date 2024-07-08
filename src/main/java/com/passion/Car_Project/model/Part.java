package com.passion.Car_Project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Part {

    private String partId;

    private String name;

//    private String description;
//
//    private Double price;
//
//    private String availability;


    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    public String getAvailability() {
//        return availability;
//    }

//    public void setAvailability(String availability) {
//        this.availability = availability;
//    }

//    @Override
//    public String toString() {
//        return "Part{" +
//                "partId='" + partId + '\'' +
//                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", price=" + price +
//                '}';
//    }
}
