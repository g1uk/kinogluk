package com.lisovskiy.kinogluk.service.impl;

import com.lisovskiy.kinogluk.entity.Company;
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
}
