/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.service;

import com.example.backend.model.Appeal;
import com.example.backend.repository.AppealRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Polly
 */
@Service
public class AppealService {
    @Autowired
    private AppealRepository appealRepository;
    
    public Page<Appeal> getNotAnsweredAppeals(Pageable pageable) {
        return appealRepository.getNotAnsweredList(pageable);
    }
    
    public Page<Appeal> getAnsweredAppeals(Pageable pageable) {
        return appealRepository.getAnsweredList(pageable);
    }

    public void deleteAllAppeals() {
       appealRepository.deleteAll();
    }
    
    @Transactional
    public void updateAnsweredAppeals(List<Integer> listId){
        appealRepository.updateAnswered(listId);
    }
    
    public void addAppeal(Appeal appeal) {
        appealRepository.saveAndFlush(appeal);
    }
}
