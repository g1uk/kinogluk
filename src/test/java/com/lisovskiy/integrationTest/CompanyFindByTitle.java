package com.lisovskiy.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.request.CompanyRequest;
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
        CompanyRequest request = new CompanyRequest();
        request.setTitle("New");
        companyService.save(request);
        assertEquals(request.getTitle(), companyService.findByTitle(request.getTitle()).getTitle());
    }
}
