package com.lisovskiy.kinogluk.controller;

import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.request.CompanyRequest;
import com.lisovskiy.kinogluk.service.impl.CompanyServiceImpl;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/company")
    @ResponseStatus(HttpStatus.CREATED)
    public Company add (@RequestBody CompanyRequest request) { return companyService.save(request);}

    @PostMapping("/company/{companyId}")
    public Company edit (@PathVariable("companyId") int id, @RequestBody CompanyRequest request) {
        return companyService.edit(id, request);
    }

    @PostMapping("/company/delete/{companyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById (@PathVariable("companyId") int id) {
        companyService.deleteById(id);
    }

}
