/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.controller;

import com.example.backend.model.Vacancy;
import com.example.backend.service.VacancyService;
import jakarta.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Polly
 */
@RestController
@RequestMapping(path="/api") 
public class VacancyController {
    @Autowired
    private VacancyService vacancyService;
    
    @RequestMapping(method = RequestMethod.GET, path="/listVacancies/page={pageNumber}")
    @PreAuthorize("isAuthenticated()")
    public Page<Vacancy> getAllVacancies(@PathVariable ("pageNumber") Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10);
        Page<Vacancy> listVacancies = vacancyService.getAllVacancies(pageable);
        return listVacancies;
    }
    
    @RequestMapping(method = RequestMethod.GET, path="/listShowingVacancies/page={pageNumber}")
    public Page<Vacancy> getAllShowingVacancies(@PathVariable ("pageNumber") Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10);
        Page<Vacancy> listVacancies = vacancyService.getAllShowingVacancies(pageable);
        return listVacancies;
    }
    
    @PostMapping(path = "/addVacancy")
    @PreAuthorize("isAuthenticated()")
    public void addVacancy(@RequestBody Vacancy vacancy) {
        vacancyService.addVacancy(vacancy);
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/vacancy/{vacancyId}")
    @PreAuthorize("isAuthenticated()")
    public Vacancy getVacancyById(HttpServletRequest request, @PathVariable Integer vacancyId) {
        Vacancy vacancy = vacancyService.findVacancyById(vacancyId);
        return vacancy;
    }
    
    @PostMapping("deleteVacancy/{vacancyId}")
    @PreAuthorize("isAuthenticated()")
    public void deleteVacancy(@PathVariable("vacancyId") Integer vacancyId) {
        vacancyService.deleteVacancy(vacancyId);
    }
    
    @PostMapping(value = "updateVacancy/{vacancyId}")
    @PreAuthorize("isAuthenticated()")
    public void updateVacancy(
            @PathVariable("vacancyId") Integer vacancyId,
            @RequestBody Vacancy vacancy)
            {
        vacancyService.updateVacancy(vacancy, vacancyId);
    }
}
