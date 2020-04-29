package com.lisovskiy.kinogluk.controller;

import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.service.impl.CompanyServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/games")
public class CompanyController {

    private final CompanyServiceImpl companyService;

    public CompanyController (CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }

    @GetMapping(value = "/company", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Company> findAll () {
        return companyService.findAll();
    }

    @GetMapping(value = "/company/{companyTitle}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Company findByTitle (@PathVariable("companyTitle") String title) {
        return companyService.findByTitle(title);
    }

    @PostMapping(value = "/company/{companyId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById (@PathVariable("companyId") int id) {
        companyService.delete(id);
    }

    @PostMapping(value = "/company/delete", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByTitle (@RequestBody String title) {
        companyService.deleteByTitle(title);
    }

    @PostMapping(value = "/company/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void create (@RequestBody Company company) {
        companyService.create(company);
    }

}
