package org.markandey.springsecuritydemo.service;

import lombok.AllArgsConstructor;
import org.markandey.springsecuritydemo.Model.User;
import org.markandey.springsecuritydemo.dto.LoginReq;
import org.markandey.springsecuritydemo.dto.LoginRes;
import org.markandey.springsecuritydemo.dto.RegisterReq;
import org.markandey.springsecuritydemo.dto.RegisterRes;
import org.markandey.springsecuritydemo.repository.UserRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    public RegisterRes register(RegisterReq request){
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

//        user.setRole(requ);

        userRepo.save(user);
        return new RegisterRes("Register Successfully",user.getName());
    }

    public LoginRes login(LoginReq request){
        Authentication auth=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        SecurityContextHolder
                .getContext()
                .setAuthentication(auth);

        User user=userRepo.findByEmail(request.getEmail()).orElseThrow();
        return new LoginRes(
                "Successfull login",
                user.getName()
        );
    }
}
