package com.lisovskiy.kinogluk.service.integrationTest;

import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.service.impl.CompanyServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CompanyServiceTest {

    @Autowired
    CompanyServiceImpl companyService;

    @Test
    public void create() {
        Company company = new Company();
        company.setTitle("Bethesda");
        companyService.create(company);
        assertEquals(company.getTitle(), companyService.findByTitle(company.getTitle()).getTitle());
    }

    @Test
    public void findAll() {
        List<Company> companies = companyService.findAll();
        assertEquals(companies.size(), companyService.findAll().size());
    }

    @Test
    public void update() {
        Company company = new Company();
        company.setTitle("Test Company");
        companyService.create(company);
        Company original = new Company();
        original.setTitle("Electronic Arts");
        assertEquals(original.getTitle(), companyService.update(company.getCompanyId(), original).getTitle());
    }

    @Test
    public void delete() {
        Company company = new Company();
        company.setTitle("Test company");
        companyService.create(company);
        int result = companyService.findAll().size();
        companyService.delete(company.getCompanyId());
        assertEquals(result-1, companyService.findAll().size());
    }

    @Test
    public void deleteByTitleTest() {
        Company company = new Company();
        company.setTitle("Test company");
        companyService.create(company);
        int result = companyService.findAll().size();
        companyService.deleteByTitle(company.getTitle());
        assertEquals(result-1, companyService.findAll().size());
    }
}
