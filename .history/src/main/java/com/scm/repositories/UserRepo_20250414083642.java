package com.scm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.scm.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    // extra methods db relatedoperations
    // custom query methods
    // custom finder methods

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);

}