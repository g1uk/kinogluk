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

    @GetMapping("/game/{companyTitle}")
    public String findByTitle (@PathVariable("companyTitle") String companyTitle) {
        return "Данную игру разработала: " + companyTitle;
    }

    @PostMapping("company/{id}")
    public Company add (@RequestBody Company company) { return companyService.save(company);}

}
