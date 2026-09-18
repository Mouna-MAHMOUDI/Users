package com.mouna.users.Controller;

import com.mouna.users.Entity.User;
import com.mouna.users.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(
                user.getName(),
                user.getMail()
        );
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable UUID id){
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id){
        userService.deleteUser(id);
    }

    @GetMapping("/{id}/valid")
    public boolean userExists(@PathVariable UUID id){
        return userService.userExists(id);
    }
}
