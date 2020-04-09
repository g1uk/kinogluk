package com.lisovskiy;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.controller.CompanyController;
import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.repository.CompanyRepository;
import com.lisovskiy.kinogluk.service.impl.CompanyServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = KinoglukApplication.class)
public class CompanyControllerTest {

    @Autowired
    CompanyServiceImpl companyService;

    @Autowired
    CompanyRepository companyRepository;

    public Company createRandomCompany() {
        Company company = new Company();
        company.setCompany(randomAlphabetic(10));
        return company;
    }

    @Test
    public void findAllTest() {
        CompanyController companyController = new CompanyController(new CompanyServiceImpl(companyRepository));
        assertEquals(companyRepository.findAll(), companyController.findAll());
    }

    @Test
    public void saveTest() {
        Company company = createRandomCompany();
        CompanyController companyController = new CompanyController(new CompanyServiceImpl(companyRepository));
        assertEquals(company, companyController.add(company));
    }

}
