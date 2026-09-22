package com.mouna.users.Controller;

import com.mouna.users.Entity.User;
import com.mouna.users.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(
        name = "Users",
        description = "API de gestion des utilisateurs"
)
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(
            summary = "Créer un utilisateur",
            description = "Crée un nouvel utilisateur à partir de son nom et de son adresse mail"
    )

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(
                user.getName(),
                user.getMail()
        );
    }
    @Operation(
            summary = "Récupérer un utilisateur",
            description = "Récupère les informations d'un utilisateur à partir de son identifiant"
    )
    @GetMapping("/{id}")
    public User getUser(@PathVariable UUID id){
        return userService.getUser(id);
    }

    @Operation(
            summary = "Supprimer un utilisateur",
            description = "Supprime un utilisateur à partir de son identifiant"
    )
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id){
        userService.deleteUser(id);
    }

    @Operation(
            summary = "Vérifier un utilisateur",
            description = "Retourne True si un utilisateur définit par son identifiant existe"
    )
    @GetMapping("/{id}/valid")
    public boolean userExists(@PathVariable UUID id){
        return userService.userExists(id);
    }
}
