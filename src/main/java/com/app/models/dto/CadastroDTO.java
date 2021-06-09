package com.app.models.dto;

public class CadastroDTO {

    public CadastroDTO() {
    }

    public CadastroDTO(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    private String username;
    private String password;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}