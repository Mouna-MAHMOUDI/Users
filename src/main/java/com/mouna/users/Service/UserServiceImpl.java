package com.mouna.users.Service;

import com.mouna.users.Dao.UserDao;
import com.mouna.users.Entity.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User createUser(String name, String email) {
        User user = new  User(name, email);
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
