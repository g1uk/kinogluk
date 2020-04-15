package com.lisovskiy.kinogluk.service;

import com.lisovskiy.kinogluk.entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> findAll();
    Company save (Company company);

    Company findByTitle(String title);

    void deleteAll();

    void deleteById(int id);
}
