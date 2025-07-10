package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserForm {

    @NotBlank(message = "Name is required")
    @Size(min = 3, message = "Min 3 characters required")
    private String name;

    @Email(message = "Email is not valid")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Min 6 characters required")
    private String password;

    @NotBlank(message = "About is required")
    private String about;

    @Size(min = 8, max = 10, message = "Invalid phone number")
    private String phoneNumber;

    // No-arg constructor
    public UserForm() {}

    // All-args constructor
    public UserForm(String name, String email, String password, String about, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.about = about;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Optional: toString
    @Override
    public String toString() {
        return "UserForm{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", about='" + about + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
