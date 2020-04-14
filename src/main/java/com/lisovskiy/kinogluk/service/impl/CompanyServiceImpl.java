package com.lisovskiy.kinogluk.service.impl;

import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.exceptions.CompanyNotFoundException;
import com.lisovskiy.kinogluk.repository.CompanyRepository;
import com.lisovskiy.kinogluk.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl (CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAll() { return companyRepository.findAll(); }

    @Override
    public Company save(Company company) { return companyRepository.save(company); }

    @Override
    public Company findByTitle(String title) {
        Company company = companyRepository.findByTitle(title);
        if (company == null) {
            throw new CompanyNotFoundException(title);
        }
        return company;
    }

    @Override
    public void deleteAll() {
        companyRepository.deleteAll();
    }
}
