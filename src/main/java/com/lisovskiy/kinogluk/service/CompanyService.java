package com.lisovskiy.kinogluk.service;

import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.request.CompanyRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CompanyService {

    Company save(CompanyRequest request);
    Company edit(int id, CompanyRequest request);
    Company findByTitle(String title);
    List<Company> findAll();
    void deleteAll();
    void deleteById(int id);

    @Transactional
    void deleteByTitle(String title);
}
