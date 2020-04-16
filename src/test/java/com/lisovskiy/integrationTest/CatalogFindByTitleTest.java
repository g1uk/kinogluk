package com.lisovskiy.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.request.CatalogRequest;
import com.lisovskiy.kinogluk.service.impl.CatalogServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = KinoglukApplication.class)
public class CatalogFindByTitleTest {

    @Autowired
    CatalogServiceImpl catalogService;

    @Test
    public void findByTitleTest() {
        CatalogRequest request = new CatalogRequest();
        request.setTitle("New");
        catalogService.save(request);
        assertEquals(request.getTitle(), catalogService.findByTitle(request.getTitle()).getTitle());
    }
}
