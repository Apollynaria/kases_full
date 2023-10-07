/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Polly
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "is_show")
    private Byte isShow;

    @Embedded
    private ProductDetails productDetails;

    public void setProduct(Product product) {
        this.name = product.getName();
        this.isShow = product.getIsShow();

        this.productDetails.setDescription(product.productDetails.getDescription());
        this.productDetails.setProductType(product.productDetails.getProductType());
        this.productDetails.setWeight(product.productDetails.getWeight());
        this.productDetails.setCalories(product.productDetails.getCalories());
        this.productDetails.setProtein(product.productDetails.getProtein());
        this.productDetails.setFats(product.productDetails.getFats());
        this.productDetails.setCarbohydrates(product.productDetails.getCarbohydrates());
        this.productDetails.setShelfLife(product.productDetails.getShelfLife());
        this.productDetails.setCode(product.productDetails.getCode());
    }
}
