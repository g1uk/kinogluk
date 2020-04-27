package com.lisovskiy.kinogluk.service.integrationTest;

import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.exceptions.CompanyNotFoundException;
import com.lisovskiy.kinogluk.service.impl.CompanyServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CompanyServiceTest {

    @Autowired
    CompanyServiceImpl companyService;

    @Test
    public void create() {
        String title = "Bethesda";
        Company company = new Company();
        company.setTitle(title);
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
        String title = "Test company";
        String newTitle = "Santa Monica";
        Company company = new Company();
        company.setTitle(title);
        companyService.create(company);
        int companyId = company.getCompanyId();
        Company original = new Company();
        original.setTitle(newTitle);
        assertEquals(original.getTitle(), companyService.update(companyId, original).getTitle());
    }

    @Test
    public void delete() {
        String title = "Test company";
        Company company = new Company();
        company.setTitle(title);
        companyService.create(company);
        int companyId = company.getCompanyId();
        Company insertedCompany = companyService.findByTitle(title);
        assertNotNull(insertedCompany);
        companyService.delete(companyId);
        assertThrows(CompanyNotFoundException.class, () -> {
            companyService.findByTitle(title);
        });
    }

    @Test
    public void deleteByTitleTest() {
        String title = "Test company";
        Company company = new Company();
        company.setTitle(title);
        companyService.create(company);
        Company companyInsert = companyService.findByTitle(title);
        assertNotNull(companyInsert);
        companyService.deleteByTitle(title);
        assertThrows(CompanyNotFoundException.class, () -> {
            companyService.findByTitle(title);
        });
    }
}
