/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.backend.repository;

import com.example.backend.model.News;
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
public interface NewsRepository extends JpaRepository<News, Integer>{
    
    @Query("select n from News n order by n.date desc")
    public Page<News> getList(Pageable pageable);
    
    @Query("select n from News n where n.isShow = true order by n.date desc")
    public Page<News> getShowingNews(Pageable pageable);
    
    @Query("select n from News n where n.isShow = true order by n.date desc limit 3")
    public List<News> getTop3ShowingNews();
    
    @Query("select n from News n where n.id = :newsId")
    public News getNewsById(@Param("newsId") Integer newsId);
    
    @Query("select n from News n where n.id = :newsId and n.isShow = true")
    public News getShowingNewsById(@Param("newsId") Integer newsId);
    
    @Query("select n.files from News n where n.id =:newsId")
    public List<String> getFilesNewsById(@Param("newsId") Integer newsId);
    
    
}
