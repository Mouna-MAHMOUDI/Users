package com.mouna.users.Service;

import com.mouna.users.Entity.User;

import java.util.UUID;

public interface UserService {
    User createUser(String name, String email);
    User getUser(UUID id);
    void deleteUser(UUID id);
    boolean userExists(UUID id);
}
