/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.service;

import com.example.backend.model.Vacancy;
import com.example.backend.repository.VacancyRepository;
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
public class VacancyService {
    @Autowired
    private VacancyRepository vacancyRepository;
    
    public Page<Vacancy> getAllVacancies(Pageable pageable) {
        return vacancyRepository.getList(pageable);
    }
    
    public Page<Vacancy> getAllShowingVacancies(Pageable pageable) {
        return vacancyRepository.getShowingVacancy(pageable);
    }
    
    public void addVacancy(Vacancy vacancy) {
        vacancyRepository.saveAndFlush(vacancy);
    }
    
    public Vacancy findVacancyById(Integer vacancyId) {
        return vacancyRepository.getVacancyById(vacancyId);
    }
    
    public void deleteVacancy(Integer vacancyId) {
        vacancyRepository.deleteById(vacancyId);
    }
    
    public void updateVacancy(Vacancy newVacancy, Integer vacancyId) {
        Vacancy vacancy = vacancyRepository.getVacancyById(vacancyId);
        vacancy.setVacancy(newVacancy);
        vacancyRepository.save(vacancy);
    }
}
