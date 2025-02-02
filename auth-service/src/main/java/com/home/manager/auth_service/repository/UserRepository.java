package com.home.manager.auth_service.repository;

import com.home.manager.auth_service.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends org.springframework.data.jpa.repository.JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
