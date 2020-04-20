package com.lisovskiy.kinogluk.controller;

import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.request.CompanyRequest;
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

    @PostMapping(value = "/company", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Company add (@RequestBody CompanyRequest request) {
        return companyService.save(request);
    }

    @PostMapping(value = "/company/{companyId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Company edit (@PathVariable("companyId") int id, @RequestBody CompanyRequest request) {
        return companyService.edit(id, request);
    }

    @PostMapping(value = "/company/delete/{companyId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById (@PathVariable("companyId") int id) {
        companyService.deleteById(id);
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

    @PostMapping(value = "/company/update/{companyId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update (@PathVariable("companyId") int id, @RequestBody Company company) {
        companyService.update(id, company);
    }

}
