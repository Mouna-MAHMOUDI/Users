package com.mouna.users.Service;

import com.mouna.users.Dao.UserDao;
import com.mouna.users.Entity.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    public UserDetailsServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        User user = userDao.findByMail(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Utilisateur introuvable"));

        return new org.springframework.security.core.userdetails.User(
                user.getMail(),
                user.getPassword(),
                Collections.singletonList(
                        new SimpleGrantedAuthority(user.getRole())
                )
        );
    }
}
