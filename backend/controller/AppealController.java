/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.controller;

import com.example.backend.model.Appeal;
import com.example.backend.service.AppealService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Polly
 */
@RestController
@RequestMapping(path="/api") 
public class AppealController {
    
    @Autowired
    private AppealService appealService;
     
    @RequestMapping(method = RequestMethod.GET, path="/listNotAnsweredAppeals/page={pageNumber}")
    @PreAuthorize("isAuthenticated()")
    public Page<Appeal> getNotAnsweredAppeal(@PathVariable ("pageNumber") Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 6);
        Page<Appeal> listApeals = appealService.getNotAnsweredAppeals(pageable);
        return listApeals;
    }
    
    @RequestMapping(method = RequestMethod.GET, path="/listAnsweredAppeals/page={pageNumber}")
    @PreAuthorize("isAuthenticated()")
    public Page<Appeal> getAnsweredAppeal(@PathVariable ("pageNumber") Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 6);
        Page<Appeal> listApeals = appealService.getAnsweredAppeals(pageable);
        return listApeals;
    }
    
    @PostMapping("/deleteAllAppeals")
    @PreAuthorize("isAuthenticated()")
    public void deleteAllAppeals() {
        appealService.deleteAllAppeals();
    }
    
    @PostMapping("/updateAnsweredAppeals")
    @PreAuthorize("isAuthenticated()")
    public void updateAnsweredAppeals(@RequestBody List<Integer> listId) {
        appealService.updateAnsweredAppeals(listId);
    }
    
    @PostMapping(path = "/addAppeal")
    public void addAppeal(@RequestBody Appeal appeal) {
        appealService.addAppeal(appeal);
    }
}
