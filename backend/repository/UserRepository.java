/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.backend.repository;

import com.example.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Polly
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
    @Query("select u from User u where u.login = :login")
    public User findByLogin(@Param("login") String login);
    
    public boolean existsByLogin(String login);
    
}
