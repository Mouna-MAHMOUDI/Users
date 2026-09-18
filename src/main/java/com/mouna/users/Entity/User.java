package com.mouna.users.Entity;

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

    protected User(){
    }

    public User(String name, String mail){
        this.name =name;
        this.mail = mail;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
