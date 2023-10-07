/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.service;

import com.example.backend.FileUtil;
import com.example.backend.model.Product;
import com.example.backend.model.ProductDetails;
import com.example.backend.otherClasses.ProductTotal;
import com.example.backend.repository.ProductRepository;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Polly
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private FileUtil fileUtil;
    
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.getAllProducts(pageable);
    }
    
    public Page<ProductTotal> getAllShowingProducts(Pageable pageable) {
        return productRepository.getShowingProducts(pageable);
    }
    
    public Page<ProductTotal> getAllShowingProductsByType(Integer productTypeId, Pageable pageable) {
        return productRepository.getAllShowingProductsByType(productTypeId, pageable);
    } 
    
    public Page<Product> getAllProductsByType(Integer productTypeId, Pageable pageable) {
        return productRepository.getAllProductsByType(productTypeId, pageable);
    }
    
    public ProductTotal findProductInfoById(Integer productId) {
        return productRepository.getProductInfoById(productId);
    }
    
    
    public String saveFile(MultipartFile file) throws IOException {
        if (file == null){
            return "";
        }
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        return fileUtil.saveFile(fileName, file);
    }
    
    public void deleteFile(String fileName){
        fileUtil.deleteFile(fileName);
    }
    
    
    public void addProduct(Product product, MultipartFile file) throws IOException {
        String fileName = saveFile(file);
        ProductDetails productDetails = product.getProductDetails();
        productDetails.setPhoto(fileName);
        productRepository.saveAndFlush(product);
    }

    public void deleteProduct(Integer productId) throws IOException {
        String fileName = productRepository.getFileProductById(productId);
        deleteFile(fileName);
        productRepository.deleteById(productId);
    }
    
    public ResponseEntity<?> getFile(String fileName) throws IOException {
        FileUtil downloadUtil = new FileUtil();
        Resource resource = null;
        try {
            resource = downloadUtil.getFileAsResource(fileName);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
         
        if (resource == null) {
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }
         
        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";
        byte[] headerBytes = headerValue.getBytes("ISO-8859-1");
        headerValue = new String(headerBytes, "UTF-8");
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);  
    }
    
    public void updateProduct(Product newProduct, Integer productId, MultipartFile multipartFile) throws IOException {
        Product product = productRepository.getProductById(productId);
        product.setProduct(newProduct);
        if (multipartFile != null) {
            System.out.println(product.getProductDetails().getPhoto());
            product.getProductDetails().setPhoto(saveFile(multipartFile));
            System.out.println(product.getProductDetails().getPhoto());
        }
        productRepository.save(product);
    }

}
