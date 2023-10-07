/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.controller;

import com.example.backend.model.Product;
import com.example.backend.model.ProductDetails;
import com.example.backend.model.ProductType;
import com.example.backend.otherClasses.ProductTotal;
import com.example.backend.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Polly
 */
@RestController
@RequestMapping(path = "/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET, path = "/adminListProducts/page={pageNumber}")
    @PreAuthorize("isAuthenticated()")
    public Page<Product> getAdminAllProducts(@PathVariable ("pageNumber") Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10);
        Page<Product> listProducts = productService.getAllProducts(pageable);
        return listProducts;
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/adminListProducts/{productTypeId}/page={pageNumber}")
    @PreAuthorize("isAuthenticated()")
    public Page<Product> getAllProducstByType(HttpServletRequest request, @PathVariable Integer productTypeId, 
            @PathVariable ("pageNumber") Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10);
        Page<Product> listProducts = productService.getAllProductsByType(productTypeId, pageable);
        return listProducts;
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/listShowingProducts/page={pageNumber}")
    public Page<ProductTotal> getAllShowingProducts(@PathVariable ("pageNumber") Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10);
        Page<ProductTotal> listProducts = productService.getAllShowingProducts(pageable);
        return listProducts;    
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/listShowingProducts/{productTypeId}/page={pageNumber}")
    public Page<ProductTotal> getAllShowingProductsByType(HttpServletRequest request, @PathVariable Integer productTypeId,
            @PathVariable ("pageNumber") Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10);
        Page<ProductTotal> listProducts = productService.getAllShowingProductsByType(productTypeId, pageable);
        return listProducts;    
    }

    @RequestMapping(method = RequestMethod.GET, path = "/productInfo/{productId}")
    @PreAuthorize("isAuthenticated()")
    public ProductTotal getProductInfoById(HttpServletRequest request, @PathVariable Integer productId) {
        ProductTotal product = productService.findProductInfoById(productId);
        return product;
    }

    @PostMapping(value = "/addProduct", consumes = {"multipart/form-data"})
    @PreAuthorize("isAuthenticated()")
    public void addProduct(
            @RequestParam("name") String nameProduct,
            @RequestParam("isShow") Byte isShow,
            @RequestParam("productTypeId") Integer id,
            @RequestParam("description") String descriptionProduct,
            @RequestParam(name = "protein", required = false) Double proteinProduct,
            @RequestParam(name = "weight", required = false) Double weightProduct,
            @RequestParam(name = "calories", required = false) Double caloriesProduct,
            @RequestParam(name = "fats", required = false) Double fatsProduct,
            @RequestParam(name = "carbohydrates", required = false) Double carbohydratesProduct,
            @RequestParam(name = "shelf_life", required = false) String shelfLife,
            @RequestParam(name = "code", required = false) String code,
            @RequestParam(name = "photo", required = false) MultipartFile multipartFile)
            throws IOException {
        productService.addProduct(
                new Product(
                        null,
                        nameProduct,
                        isShow,
                        new ProductDetails(
                                new ProductType(id, "abib"),
                                descriptionProduct,
                                weightProduct,
                                caloriesProduct,
                                proteinProduct,
                                fatsProduct,
                                carbohydratesProduct,
                                shelfLife,
                                code,
                                "file"
                        )
                ), multipartFile);
    }

    @PostMapping(value = "updateProduct/{productId}", consumes = {"multipart/form-data"})
    @PreAuthorize("isAuthenticated()")
    public void updateProduct(
            @PathVariable("productId") Integer productId,
            @RequestParam("name") String nameProduct,
            @RequestParam("isShow") Byte isShow,
            @RequestParam("productTypeId") Integer id,
            @RequestParam("description") String descriptionProduct,
            @RequestParam(name = "protein", required = false) Double proteinProduct,
            @RequestParam(name = "weight", required = false) Double weightProduct,
            @RequestParam(name = "calories", required = false) Double caloriesProduct,
            @RequestParam(name = "fats", required = false) Double fatsProduct,
            @RequestParam(name = "carbohydrates", required = false) Double carbohydratesProduct,
            @RequestParam(name = "shelf_life", required = false) String shelfLife,
            @RequestParam(name = "code", required = false) String code,
            @RequestParam(name = "photo", required = false) MultipartFile multipartFile)
            throws IOException {
        productService.updateProduct(
                new Product(
                        null,
                        nameProduct,
                        isShow,
                        new ProductDetails(
                                new ProductType(id, "abib"),
                                descriptionProduct,
                                weightProduct,
                                caloriesProduct,
                                proteinProduct,
                                fatsProduct,
                                carbohydratesProduct,
                                shelfLife,
                                code,
                                "file"
                        )
                ), productId, multipartFile);
    }
            
    @GetMapping("/getFile/{fileName}")
    public ResponseEntity<?> getFile(@PathVariable("fileName") String fileName) throws IOException {
        return productService.getFile(fileName);
    }
    
    @PostMapping("deleteProduct/{productId}")
    @PreAuthorize("isAuthenticated()")
    public void deleteProduct(@PathVariable("productId") Integer productId) throws IOException {
        productService.deleteProduct(productId);
    }

}
