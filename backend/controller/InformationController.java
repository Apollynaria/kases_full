/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.controller;

import com.example.backend.model.Information;
import com.example.backend.service.InformationService;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Bibik
 */
@RestController
@RequestMapping(path = "/api")
public class InformationController {

    @Autowired
    private InformationService informationService;

    @RequestMapping(method = RequestMethod.GET, path = "/listInformation/page={pageNumber}")
    @PreAuthorize("isAuthenticated()")
    public Page<Information> getAllInformation(@PathVariable ("pageNumber") Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10);
        Page<Information> listInformation = informationService.getAllInformation(pageable);
        return listInformation;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/listShowingInformation/page={pageNumber}")
    public Page<Information> getAllShowingInformation(@PathVariable ("pageNumber") Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 8);
        Page<Information> listInformation = informationService.getAllShowingInformation(pageable);
        return listInformation;
    }


    @PostMapping(path = "/addInformation")
    @PreAuthorize("isAuthenticated()")
    public void addInformation(
            @RequestParam("name") String nameInformation,
            @RequestParam("isShow") Byte isShow,
            @RequestParam("description") String descriptionInformation,
            @RequestParam(name = "files", required = false) List<MultipartFile> list) throws IOException {

        informationService.addInformation(new Information(
                null,
                nameInformation,
                isShow,
                descriptionInformation,
                null
        ), list);

    }
    
    @PostMapping(value = "updateInformation/{informationId}", consumes = {"multipart/form-data"})
    @PreAuthorize("isAuthenticated()")
    public void updateInformation(
            @PathVariable("informationId") Integer informationId,
            @RequestParam("name") String nameInformation,
            @RequestParam("isShow") Byte isShow,
            @RequestParam("description") String descriptionInformation,
            @RequestParam(name = "files", required = false) List<MultipartFile> list)
            throws IOException {

        informationService.updateInformation(new Information(
                null,
                nameInformation,
                isShow,
                descriptionInformation,
                null
        ), informationId, list);
    }
    
    @PostMapping("deleteInformation/{informationId}")
    @PreAuthorize("isAuthenticated()")
    public void deleteInformation(@PathVariable("informationId") Integer informationId) throws IOException {
        informationService.deleteInformation(informationId);
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/adminInformation/{informationId}")
    @PreAuthorize("isAuthenticated()")
    public Information getInformationById(HttpServletRequest request, @PathVariable Integer informationId) {
        Information information = informationService.findInformationById(informationId);
        return information;
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/information/{informationId}")
    public Information getShowingInformationById(HttpServletRequest request, @PathVariable Integer informationId) {
        Information information = informationService.findShowingInformationById(informationId);
        return information;
    }
    

}
