package org.markandey.springsecuritydemo.repository;

import org.markandey.springsecuritydemo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}
