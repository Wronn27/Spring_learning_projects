package org.markandey.springsecuritydemo.config;

import org.markandey.springsecuritydemo.Model.User;
import org.markandey.springsecuritydemo.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    public MyUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails
                .User
                .builder()
                .username(user.getEmail())
                .password(user.getPassword())
//                .roles(user.getRole())
                .build();
    }
}
