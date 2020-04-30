package com.lisovskiy.kinogluk.service.impl;

import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.exceptions.CompanyDoesNotExistsException;
import com.lisovskiy.kinogluk.exceptions.CompanyIsAlreadyExistsException;
import com.lisovskiy.kinogluk.exceptions.CompanyNotFoundException;
import com.lisovskiy.kinogluk.repository.CompanyRepository;
import com.lisovskiy.kinogluk.service.CompanyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl (CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public Company create(Company company) {
        List<Company> companies = companyRepository.findAll();
        for (Company temp : companies
             ) {
            if (temp.getTitle().equals(company.getTitle())) {
                throw new CompanyIsAlreadyExistsException(company.getTitle());
            } else entityManager.persist(company);
        }
        return company;
    }

    @Transactional
    public Company update(int id, Company company) {
        Company original = entityManager.find(Company.class, id);
        if (original != null) {
            original.setTitle(company.getTitle());
            entityManager.merge(original);
        } else throw new CompanyDoesNotExistsException(id);
        return original;
    }

    @Transactional
    public void delete(int id) {
        Company company = entityManager.find(Company.class, id);
        if (company != null) {
            entityManager.remove(company);
        }
        else throw new CompanyDoesNotExistsException(id);
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findByTitle(String title) {
        Company company = companyRepository.findByTitle(title);
        if (company == null) {
            throw new CompanyNotFoundException(title);
        }
        return company;
    }

    public void deleteAll() {
        companyRepository.deleteAll();
    }

    @Override
    @Transactional
    public void deleteByTitle(String title) {
        List<Company> companies = companyRepository.findAll();
        for (Company temp : companies
             ) {
            if (temp.getTitle().equals(title)) {
                companyRepository.deleteByTitle(title);
            } else throw new CompanyDoesNotExistsException(title);
        }

    }
}
