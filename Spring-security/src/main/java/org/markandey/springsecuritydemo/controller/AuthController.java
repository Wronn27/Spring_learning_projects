package org.markandey.springsecuritydemo.controller;

import lombok.AllArgsConstructor;
import org.markandey.springsecuritydemo.dto.LoginReq;
import org.markandey.springsecuritydemo.dto.LoginRes;
import org.markandey.springsecuritydemo.dto.RegisterReq;
import org.markandey.springsecuritydemo.dto.RegisterRes;
import org.markandey.springsecuritydemo.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@ResponseBody
public class AuthController {

    private AuthService authService;


    @PostMapping("/register")
    public RegisterRes register(@ModelAttribute RegisterReq request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public LoginRes login(@ModelAttribute LoginReq request){
        return authService.login(request);
    }
}
