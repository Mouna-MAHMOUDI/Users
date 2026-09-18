package com.mouna.users.Dao;

import com.mouna.users.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaUserDao
        extends JpaRepository<User, UUID>, UserDao{
}
