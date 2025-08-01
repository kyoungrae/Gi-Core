package com.gicore.common.common.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommonUserRepository extends JpaRepository<User , Integer> {
    Optional<User> findByEmail(String email);
}
