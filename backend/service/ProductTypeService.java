/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.service;

import com.example.backend.model.ProductType;
import com.example.backend.repository.ProductTypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Polly
 */
@Service
public class ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;
    
    public List<ProductType> getAllProductTypes() {
        return productTypeRepository.getAllProductTypes();
    }
}

