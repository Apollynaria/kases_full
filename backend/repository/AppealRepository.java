/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.backend.repository;

import com.example.backend.model.Appeal;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Polly
 */
public interface AppealRepository extends JpaRepository<Appeal, Integer>{
    
    @Query("select p from Appeal p order by p.id")
    public Page<Appeal> getList(Pageable pageable);
    
    @Query("select p from Appeal p where p.answered = false order by p.id desc")
    public Page<Appeal> getNotAnsweredList(Pageable pageable);
    
    @Query("select p from Appeal p where p.answered = true order by p.id desc")
    public Page<Appeal> getAnsweredList(Pageable pageable);
    
    @Modifying
    @Query("update Appeal p set p.answered = true where p.id in (:listId)")
    public void updateAnswered(@Param("listId") List<Integer> listId);
}
