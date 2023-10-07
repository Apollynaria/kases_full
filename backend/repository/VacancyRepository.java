/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.backend.repository;

import com.example.backend.model.Vacancy;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Polly
 */
@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Integer>{
    
    @Query("select v from Vacancy v order by v.name")
    public Page<Vacancy> getList(Pageable pageable);
    
    @Query("select v from Vacancy v where v.isShow = true order by v.name")
    public Page<Vacancy> getShowingVacancy(Pageable pageable);
    
    @Query("select v from Vacancy v where v.id = :vacancyId")
    public Vacancy getVacancyById(@Param("vacancyId") Integer vacancyId);
   
}
