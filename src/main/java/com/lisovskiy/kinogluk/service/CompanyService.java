package com.lisovskiy.kinogluk.service;

import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.request.CompanyRequest;

import java.util.List;

public interface CompanyService {

    List<Company> findAll();

    Company save(CompanyRequest request);

    Company edit(int id, CompanyRequest request);

    Company findByTitle(String title);

    void deleteAll();

    void deleteById(int id);
}
