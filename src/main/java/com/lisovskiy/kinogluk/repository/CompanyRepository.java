package com.lisovskiy.kinogluk.repository;

import com.lisovskiy.kinogluk.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends CrudRepository <Company, Long> {

    List<Company> findAll();
    Company save (Company company);
}
