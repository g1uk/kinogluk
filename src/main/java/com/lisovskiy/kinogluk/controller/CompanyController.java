package com.lisovskiy.kinogluk.controller;

import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.service.impl.CompanyServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/games")
public class CompanyController {

    private final CompanyServiceImpl companyService;

    public CompanyController (CompanyServiceImpl companyService) {this.companyService = companyService;}

    @GetMapping("/company")
    public List<Company> findAll () {return companyService.findAll();}

    @GetMapping("/company/{companyTitle}")
    public Company findByTitle (@PathVariable("companyTitle") String title) {
        return companyService.findByTitle(title);
    }

    @PostMapping("company/{id}")
    public Company add (@RequestBody Company company) { return companyService.save(company);}

}
