/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Embeddable
public class ProductDetails {

    @ManyToOne
    @JoinColumn(name="product_type_id")
    private ProductType productType;
    
    private String description;
    private Double weight;
    private Double calories;
    private Double protein;
    private Double fats;
    private Double carbohydrates;

    @Column(name = "shelf_life")
    private String shelfLife;

    private String code;
    private String photo;
}
