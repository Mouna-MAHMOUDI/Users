package com.mouna.users.Service;

import com.mouna.users.Dao.UserDao;
import com.mouna.users.Entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService{

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User login(String mail, String password) {
        Optional<User> user = userDao.findByMail(mail);

        User utilisateur = user.orElseThrow(()-> new RuntimeException("Identifiants incorrects"));

        boolean correct = passwordEncoder.matches(password, utilisateur.getPassword());

        if (!correct){
            throw new RuntimeException("Identifiants incorrects");
        }
        return utilisateur;
    }
}
