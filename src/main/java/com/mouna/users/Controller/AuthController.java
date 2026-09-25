package com.mouna.users.Controller;

import com.mouna.users.Entity.LoginRequest;
import com.mouna.users.Entity.User;
import com.mouna.users.Service.AuthService;
import com.mouna.users.security.JwtService;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                request.mail(),
                request.password()
        )
        );

        String role = authentication.getAuthorities()
                .iterator()
                .next()
                .getAuthority();

        String token= jwtService.generateToken(
                request.mail(),
                role
        );

        return token;
    }

    @GetMapping("/test-token")
    public boolean testToken(@RequestHeader("Authorization") String authorization) {

        String token = authorization.substring(7);

        return jwtService.isTokenValid(token);
    }
}
