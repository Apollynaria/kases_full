/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.otherClasses;

import com.example.backend.model.ProductType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Polly
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductTotal {
    private Integer id;
    private String name;
    private Byte isShow;
    private Integer productTypeId;
    private String description;
    private Double weight;
    private Double calories;
    private Double protein;
    private Double fats;
    private Double carbohydrates;
    private String shelfLife;
    private String code;
    private String photo; 
}
