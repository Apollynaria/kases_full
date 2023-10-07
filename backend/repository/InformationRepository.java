/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.repository;

import com.example.backend.model.Information;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bibik
 */
@Repository
public interface InformationRepository extends JpaRepository<Information, Integer>{
    
    @Query("select i from Information i order by i.name")
    public Page<Information> getList(Pageable pageable);
    
    @Query("select i from Information i where i.isShow = true order by i.name")
    public Page<Information> getShowingInformation(Pageable pageable);
    
    @Query("select i from Information i where i.id = :informationId")
    public Information getInformationById(@Param("informationId") Integer informationId);
    
    @Query("select i from Information i where i.id = :informationId and i.isShow = true")
    public Information getShowingInformationById(@Param("informationId") Integer informationId);
    
    @Query("select i.files from Information i where i.id =:informationId")
    public List<String> getFilesInformationById(@Param("informationId") Integer informationId);
    
}
