/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.backend.repository;

import com.example.backend.model.Product;
import com.example.backend.otherClasses.ProductTotal;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Polly
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    
    @Query("select p from Product p order by p.name")
    public Page<Product> getAllProducts(Pageable pageable);
    
    @Query("select new com.example.backend.otherClasses.ProductTotal( "
            + "p.id, "
            + "p.name, "
            + "p.isShow, "
            + "p.productDetails.productType.id, "
            + "p.productDetails.description, "
            + "p.productDetails.weight, "
            + "p.productDetails.calories, "
            + "p.productDetails.protein, "
            + "p.productDetails.fats, "
            + "p.productDetails.carbohydrates, "
            + "p.productDetails.shelfLife, "
            + "p.productDetails.code, "
            + "p.productDetails.photo ) from Product p where p.isShow = true order by p.name")
    public Page<ProductTotal> getShowingProducts(Pageable pageable);
    
    
    @Query("select p from Product p where p.productDetails.productType.id = :productTypeId order by p.name")
    public Page<Product> getAllProductsByType(@Param("productTypeId") Integer productTypeId, Pageable pageable);
    
    @Query("select new com.example.backend.otherClasses.ProductTotal( "
            + "p.id, "
            + "p.name, "
            + "p.isShow, "
            + "p.productDetails.productType.id, "
            + "p.productDetails.description, "
            + "p.productDetails.weight, "
            + "p.productDetails.calories, "
            + "p.productDetails.protein, "
            + "p.productDetails.fats, "
            + "p.productDetails.carbohydrates, "
            + "p.productDetails.shelfLife, "
            + "p.productDetails.code, "
            + "p.productDetails.photo ) from Product p where p.id = :productId")
    public ProductTotal getProductInfoById(@Param("productId") Integer productId);
    
    
    
    @Query("select new com.example.backend.otherClasses.ProductTotal( "
            + "p.id, "
            + "p.name, "
            + "p.isShow, "
            + "p.productDetails.productType.id, "
            + "p.productDetails.description, "
            + "p.productDetails.weight, "
            + "p.productDetails.calories, "
            + "p.productDetails.protein, "
            + "p.productDetails.fats, "
            + "p.productDetails.carbohydrates, "
            + "p.productDetails.shelfLife, "
            + "p.productDetails.code, "
            + "p.productDetails.photo ) from Product p where p.productDetails.productType.id = :productTypeId and p.isShow = true order by p.name")
    public Page<ProductTotal> getAllShowingProductsByType(@Param("productTypeId") Integer productTypeId, Pageable pageable);
    
    @Query("select p.productDetails.photo from Product p where p.id =:productId")
    public String getFileProductById(@Param("productId") Integer productId);
    
    @Query("select p from Product p where p.id = :productId")
    public Product getProductById(@Param("productId") Integer productId);

}
