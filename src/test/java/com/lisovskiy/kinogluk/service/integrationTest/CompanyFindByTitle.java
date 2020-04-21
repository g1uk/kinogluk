package com.lisovskiy.kinogluk.service.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.service.impl.CompanyServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = KinoglukApplication.class)
public class CompanyFindByTitle {

    @Autowired
    CompanyServiceImpl companyService;

    @Test
    public void findByTitleTest() {
        Company company = new Company();
        company.setTitle("New");
        companyService.create(company);
        assertEquals(company.getTitle(), companyService.findByTitle(company.getTitle()).getTitle());
    }
}
