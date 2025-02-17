package com.home.manager.auth_service.repository;

import com.home.manager.auth_service.model.UserEntity;

public interface UserRepository extends org.springframework.data.jpa.repository.JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
