/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.service;

import com.example.backend.FileUtil;
import com.example.backend.model.Information;
import com.example.backend.repository.InformationRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Bibik
 */
@Service
public class InformationService {
    
    @Autowired
    private InformationRepository informationRepository;

    @Autowired
    private FileUtil fileUtil;

    public Page<Information> getAllInformation(Pageable pageable) {
        return informationRepository.getList(pageable);
    }

    public Page<Information> getAllShowingInformation(Pageable pageable) {
        return informationRepository.getShowingInformation(pageable);
    }
    
    public void addInformation(Information information, List<MultipartFile> listFiles) throws IOException {
        if (listFiles != null) {
            List<String> fileNames = saveFiles(listFiles);
            information.setFiles(fileNames);
        }

        informationRepository.saveAndFlush(information);
    }

    public void updateInformation(Information newInformation, Integer informationId, List<MultipartFile> listFiles) throws IOException {
        Information information = informationRepository.getInformationById(informationId);
        System.out.println(information);
        information.setInformation(newInformation);

        if (listFiles != null) {
            List<String> filesName = informationRepository.getFilesInformationById(informationId);
            deleteFiles(filesName);
            
            List<String> fileNames = saveFiles(listFiles);
            information.setFiles(fileNames);
            System.out.println(information);
        }
        informationRepository.save(information);
    }

    public void deleteInformation(Integer informationId) throws IOException {
        List<String> filesName = informationRepository.getFilesInformationById(informationId);
        deleteFiles(filesName);
        informationRepository.deleteById(informationId);
    }

    public List<String> saveFiles(List<MultipartFile> files) throws IOException {
        List<String> stringFiles = new ArrayList();
        for (int i = 0; i < files.size(); i++) {
            if (files.get(i) == null) {
                stringFiles.add("");
            }
            String fileName = StringUtils.cleanPath(files.get(i).getOriginalFilename());
            stringFiles.add(fileUtil.saveFile(fileName, files.get(i)));
        }
        return stringFiles;
    }

    public void deleteFiles(List<String> fileNames) {
        for (int i = 0; i < fileNames.size(); i++) {
            fileUtil.deleteFile(fileNames.get(i));
        }
    }

    public Information findInformationById(Integer informationId) {
        return informationRepository.getInformationById(informationId);
    }

    public Information findShowingInformationById(Integer informationId) {
        return informationRepository.getShowingInformationById(informationId);
    }
}
