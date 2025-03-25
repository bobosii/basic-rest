package dev.emir.dto;

import dev.emir.entities.Customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class CustomerSaveRequest {
    private int id;
    @NotNull
    private String name;
    @Email
    private String mail;
    private Customer.Gender gender;

    public CustomerSaveRequest() {
    }

    public CustomerSaveRequest(int id, String name, String mail, Customer.Gender gender) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Customer.Gender getGender() {
        return gender;
    }

    public void setGender(Customer.Gender gender) {
        this.gender = gender;
    }
}
