package com.lisovskiy.kinogluk.service.impl;

import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.entity.Game;
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
        for (Game game : company.getGames()
        ) {
            game.setCompany(company);
        }
        entityManager.persist(company);
        return company;
    }

    @Transactional
    public Company update(int id, Company company) {
        Company original = entityManager.find(Company.class, id);
        if (original != null) {
            original.setTitle(company.getTitle());
            for (Game game : original.getGames()
                 ) {
                entityManager.remove(game);
            }
            original.getGames().clear();
            for (Game game : original.getGames()
                 ) {
                game.setCompany(original);
                original.getGames().add(game);
                entityManager.persist(game);
            }
            entityManager.merge(original);
        }
        return original;
    }

    @Transactional
    public void delete(int id) {
        Company company = entityManager.find(Company.class, id);
        if (company != null) {
            entityManager.remove(company);
        }
        else throw new CompanyNotFoundException(id);
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

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

    @Override
    public void deleteById(int id) {
        if (!companyRepository.existsById(id)) {
            throw new CompanyNotFoundException(id);
        }
        companyRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteByTitle(String title) {
        companyRepository.deleteByTitle(title);
    }
}
