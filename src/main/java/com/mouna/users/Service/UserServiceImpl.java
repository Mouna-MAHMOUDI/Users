package com.mouna.users.Service;

import com.mouna.users.Dao.UserDao;
import com.mouna.users.Entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User createUser(String name, String email, String password) {
        String passwordHash = passwordEncoder.encode(password);
        User user = new  User(name, email, passwordHash,"ROLE_USER");
        return userDao.save(user);
    }

    @Override
    public User getUser(UUID id) {
        return userDao.findById(id).orElseThrow(() ->
                new RuntimeException("Utilisateur introuvable"));
    }

    @Override
    public void deleteUser(UUID id) {
        if(!userDao.existsById(id)){
            throw new RuntimeException("Utilisateur introuvable");
        }
        userDao.deleteById(id);
    }

    @Override
    public boolean userExists(UUID id) {
        return userDao.existsById(id);
    }
}
