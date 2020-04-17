package com.lisovskiy.kinogluk.repository;

import com.lisovskiy.kinogluk.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CompanyRepository extends CrudRepository <Company, Integer> {

    List<Company> findAll();
    Company save (Company company);
    Company findByTitle (String title);
    void deleteById (int id);
    @Transactional
    void deleteByTitle (String title);
}
