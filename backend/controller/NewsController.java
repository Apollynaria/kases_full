/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.controller;

import com.example.backend.model.News;
import com.example.backend.service.NewsService;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Polly
 */
@RestController
@RequestMapping(path = "/api")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(method = RequestMethod.GET, path = "/listNews/page={pageNumber}")
    @PreAuthorize("isAuthenticated()")
    public Page<News> getAllNews(@PathVariable ("pageNumber") Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10);
        Page<News> listNews = newsService.getAllNews(pageable);
        return listNews;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/listShowingNews/page={pageNumber}")
    public Page<News> getAllShowingNews(@PathVariable ("pageNumber") Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 8);
        Page<News> listNews = newsService.getAllShowingNews(pageable);
        return listNews;
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/listTop3ShowingNews")
    public List<News> getTop3ShowingNews() {
        List<News> listNews = newsService.getTop3ShowingNews();
        return listNews;
    }

    @PostMapping(path = "/addNews")
    @PreAuthorize("isAuthenticated()")
    public void addNews(
            @RequestParam("name") String nameNews,
            @RequestParam("isShow") Byte isShow,
            @RequestParam("description") String descriptionNews,
            @RequestParam("date") String dateNews,
            @RequestParam(name = "files", required = false) List<MultipartFile> list) throws IOException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.US);
        LocalDate date = LocalDate.parse(dateNews, formatter);

        newsService.addNews(new News(
                null,
                nameNews,
                isShow,
                descriptionNews,
                date,
                null
        ), list);

    }
    
    @PostMapping(value = "updateNews/{newsId}", consumes = {"multipart/form-data"})
    @PreAuthorize("isAuthenticated()")
    public void updateNews(
            @PathVariable("newsId") Integer newsId,
            @RequestParam("name") String nameNews,
            @RequestParam("isShow") Byte isShow,
            @RequestParam("description") String descriptionNews,
            @RequestParam("date") String dateNews,
            @RequestParam(name = "files", required = false) List<MultipartFile> list)
            throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.US);
        LocalDate date = LocalDate.parse(dateNews, formatter);
        
        System.out.println("BBBBBBBBBBB "+list);
        newsService.updateNews(new News(
                null,
                nameNews,
                isShow,
                descriptionNews,
                date,
                null
        ), newsId, list);
    }
    
    @PostMapping("deleteNews/{newsId}")
    @PreAuthorize("isAuthenticated()")
    public void deleteNews(@PathVariable("newsId") Integer newsId) throws IOException {
        newsService.deleteNews(newsId);
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/adminNews/{newsId}")
    @PreAuthorize("isAuthenticated()")
    public News getNewsById(HttpServletRequest request, @PathVariable Integer newsId) {
        News news = newsService.findNewsById(newsId);
        return news;
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/news/{newsId}")
    public News getShowingNewsById(HttpServletRequest request, @PathVariable Integer newsId) {
        News news = newsService.findShowingNewsById(newsId);
        return news;
    }
    

}
