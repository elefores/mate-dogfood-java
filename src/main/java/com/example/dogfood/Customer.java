package com.example.dogfood;

// These Bean Validation imports live under `javax.validation` in Spring Boot 2.x.
// Spring Boot 3 moves them to `jakarta.validation`, so an upgrade has to rewrite
// every one of these imports.
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Customer {

    @NotBlank
    private String name;

    @Email
    private String email;

    @Min(18)
    @Max(120)
    private int age;

    public Customer() {
    }

    public Customer(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
