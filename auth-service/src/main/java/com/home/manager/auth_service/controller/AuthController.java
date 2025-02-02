package com.home.manager.auth_service.controller;

import com.home.manager.auth_service.model.UserEntity;
import com.home.manager.auth_service.repository.UserRepository;
import com.home.manager.auth_service.service.CustomUserDetailsService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    private final String SECRET_KEY = "mysecretkey";

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/register")
    public String register(@RequestBody UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody UserEntity user) {
        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
//            );

            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());

            String token = Jwts.builder()
                    .setSubject(userDetails.getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 godzina
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();

            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return response;

        } catch (BadCredentialsException e) {
            throw new RuntimeException("Invalid username or password");
        }
    }
}