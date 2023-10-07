/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.controller;

import com.example.backend.model.ProductType;
import com.example.backend.service.ProductTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Polly
 */
@RestController
@RequestMapping(path="/api") 
public class ProductTypeController {
    @Autowired
    private ProductTypeService productTypeService;
    
   @RequestMapping(method = RequestMethod.GET, path="/listProductTypes")
    public List<ProductType> getAllProductTypes() {
        List<ProductType> listProductTypes = productTypeService.getAllProductTypes();
        return listProductTypes;
    }
}
