package com.ust.IQair.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.IQair.model.User;

@Repository
public interface UserAuthenticationRepository extends JpaRepository<User, String> {
    
    User findByUserIdAndUserPassword(String userId, String userPassword);
}