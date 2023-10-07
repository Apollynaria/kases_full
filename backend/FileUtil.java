/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend;

/**
 *
 * @author Polly
 */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
 
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
 
@Component
public class FileUtil {
    final private Path dirPath = Paths.get("files");
    public void deleteFile(String fileName){
        File file = new File(dirPath.getFileName()+"/"+fileName);
        System.out.println(dirPath.getFileName());
        file.delete();
    }
    public String saveFile(String fileName, MultipartFile multipartFile)
            throws IOException {
          
        if (!Files.exists(dirPath)) {
            Files.createDirectories(dirPath);
        }
        String fileCode = RandomStringUtils.randomAlphanumeric(8);
        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = dirPath.resolve(fileCode + "-" + fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {       
            throw new IOException("Could not save file: " + fileName, ioe);
        }
        return fileCode+"-"+fileName;
    }
    
    //DOWNLOAD
    private Path foundFile;
     
    public Resource getFileAsResource(String fileName) throws IOException {
         
        Files.list(dirPath).forEach(file -> {
            if (file.getFileName().toString().startsWith(fileName)) {
                foundFile = file;
                return;
            }
        });
 
        if (foundFile != null) {
            return new UrlResource(foundFile.toUri());
        }
         
        return null;
    }
}
