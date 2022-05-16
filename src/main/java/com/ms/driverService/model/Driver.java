package com.ms.driverService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("drivers")
public class Driver {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String[] contactNumbers;
    private int rating;

    public Driver(String id, String firstName, String lastName, String[] contactNumbers, int rating) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumbers = contactNumbers;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String[] getContactNumbers() {
        return contactNumbers;
    }

    public void setContactNumbers(String[] contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
