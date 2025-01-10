package com.example.sensor_api.controller;

import com.example.sensor_api.util.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/token")
    public String genereteToken(@RequestParam String username) {
        return JwtUtil.generateToken(username);
    }
}
