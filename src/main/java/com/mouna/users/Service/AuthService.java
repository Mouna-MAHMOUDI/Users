package com.mouna.users.Service;

import com.mouna.users.Entity.User;

public interface AuthService {
    User login(String mail, String password);
}
