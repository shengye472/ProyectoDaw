package com.shopflow.controller;

import com.shopflow.common.util.JwtUtil;
import com.shopflow.domain.model.Users;
import com.shopflow.domain.usecase.impl.user.UserLoadUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping(UserController.URL)
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    public static final String URL = "/api/auth";

    @Autowired
    private UserLoadUseCase userLoadUseCase;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Users loginRequest){
        UserDetails user = userLoadUseCase.loadUserByUsername(loginRequest.getUsername());
        if (user == null || !user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
        String token = jwtUtil.generateToken(user);
        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }
}
