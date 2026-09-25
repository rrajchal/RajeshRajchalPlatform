package com.rajeshrajchal.platform.dto;

public class PersonResponse {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;

    public PersonResponse(
            Long id,
            String firstName,
            String lastName,
            String email,
            String phoneNumber) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}