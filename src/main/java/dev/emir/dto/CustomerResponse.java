package dev.emir.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

// Customer --> CustomerDTO
public class CustomerResponse {
    private int id;
    @NotNull
    private String name;
    @Email
    private String mail;

    public CustomerResponse(int id, String name, String mail) {
        this.id = id;
        this.name = name;
        this.mail = mail;
    }

    public CustomerResponse() {
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
}
