/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.service;

import com.example.backend.FileUtil;
import com.example.backend.model.News;
import com.example.backend.repository.NewsRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Polly
 */
@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private FileUtil fileUtil;

    public Page<News> getAllNews(Pageable pageable) {
        return newsRepository.getList(pageable);
    }

    public Page<News> getAllShowingNews(Pageable pageable) {
        return newsRepository.getShowingNews(pageable);
    }

    public List<News> getTop3ShowingNews() {
        return newsRepository.getTop3ShowingNews();
    }

    public void addNews(News news, List<MultipartFile> listFiles) throws IOException {
        if (listFiles != null) {
            List<String> fileNames = saveFiles(listFiles);
            news.setFiles(fileNames);
        }

        newsRepository.saveAndFlush(news);
    }

    public void updateNews(News newNews, Integer newsId, List<MultipartFile> listFiles) throws IOException {
        News news = newsRepository.getNewsById(newsId);
        System.out.println(news);
        news.setNews(newNews);

        if (listFiles != null) {
            List<String> filesName = newsRepository.getFilesNewsById(newsId);
            deleteFiles(filesName);
            
            List<String> fileNames = saveFiles(listFiles);
            news.setFiles(fileNames);
            System.out.println(news);
        }
        newsRepository.save(news);
    }

    public void deleteNews(Integer newsId) throws IOException {
        List<String> filesName = newsRepository.getFilesNewsById(newsId);
        deleteFiles(filesName);
        newsRepository.deleteById(newsId);
    }

    public List<String> saveFiles(List<MultipartFile> files) throws IOException {
        List<String> stringFiles = new ArrayList();
        for (int i = 0; i < files.size(); i++) {
            if (files.get(i) == null) {
                stringFiles.add("");
            }
            String fileName = StringUtils.cleanPath(files.get(i).getOriginalFilename());
            stringFiles.add(fileUtil.saveFile(fileName, files.get(i)));
        }
        return stringFiles;
    }

    public void deleteFiles(List<String> fileNames) {
        for (int i = 0; i < fileNames.size(); i++) {
            fileUtil.deleteFile(fileNames.get(i));
        }
    }

    public News findNewsById(Integer newsId) {
        return newsRepository.getNewsById(newsId);
    }

    public News findShowingNewsById(Integer newsId) {
        return newsRepository.getShowingNewsById(newsId);
    }
}
