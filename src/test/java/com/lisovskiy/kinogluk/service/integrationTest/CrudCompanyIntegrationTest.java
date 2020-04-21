package com.lisovskiy.kinogluk.service.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.entity.Company;
import com.lisovskiy.kinogluk.service.impl.CompanyServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = KinoglukApplication.class)
public class CrudCompanyIntegrationTest {

    @Autowired
    CompanyServiceImpl companyService;

    @Test
    public void CrudTestCompany() {
        companyService.deleteAll();
        Company company = new Company();
        company.setTitle("Test Company");
        Company company1 = new Company();
        company1.setTitle("New Test Company");
        companyService.update(company.getCompanyId(), company1);
        List<Company> companies = companyService.findAll();
        assertEquals(1, companies.size());
        System.out.println(companies.get(0).getTitle());
    }

    @Test
    public void deleteAllTest() {
        companyService.deleteAll();
    }

}
