package com.virtualBook.payload.test;

import jakarta.validation.constraints.*;

public class UserData {

    // Basic validation for name field, should be not empty and length between 2 and 20 characters
    @NotEmpty(message = "Name is required !!")
    @Size(min =3,max=20, message="Name is between 2 and 20")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$",
            message = "Invalid Username !! Username must contain 1 capital letter, 1 special character and 1 digit")
    private String name;

    @Email(message = "Email is required !!")
    private String email;

    @Min(value=18, message = "Minimum age is 18")
    @Max(value=99, message = "Maximum age is 99")
    private int age;

    @NotEmpty(message = "Password is required !!")
    private String password;

    // custom validator for gender
    // 1. blank not allowed
    // 2. only male female allowed
    private String gender;

    public UserData() {}

    public UserData(String name, String email, int age, String password, String gender) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.password = password;
        this.gender = gender;
    }

    public String getGender() {return gender;}

    public void setGender(String gender) {}

    String getName() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
