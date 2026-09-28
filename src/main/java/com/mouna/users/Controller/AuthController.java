package com.mouna.users.Controller;

import com.mouna.users.Entity.LoginRequest;
import com.mouna.users.Entity.User;
import com.mouna.users.Service.AuthService;
import com.mouna.users.security.JwtService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final JwtService jwtService;

    public AuthController(AuthService authService, JwtService jwtService) {
        this.authService = authService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){
        User user = authService.login(
                request.mail(),
                request.password()

        );

        String token= jwtService.generateToken(
                user.getMail(),
                user.getRole(),
                user.getId().toString()
        );

        return token;
    }

    @GetMapping("/test-token")
    public boolean testToken(@RequestHeader("Authorization") String authorization) {

        String token = authorization.substring(7);

        return jwtService.isTokenValid(token);
    }
}
