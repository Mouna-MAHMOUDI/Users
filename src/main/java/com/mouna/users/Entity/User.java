package com.mouna.users.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String mail;
    @JsonIgnore
    private String password;
    private String role;

    protected User(){
    }

    public User(String name, String mail, String password, String role){
        this.name =name;
        this.mail = mail;
        this.password = password;
        this.role=role;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() { return password; }

    public String getRole() {return role;}

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
