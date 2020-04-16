package com.lisovskiy.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.request.CatalogRequest;
import com.lisovskiy.kinogluk.service.impl.CatalogServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = KinoglukApplication.class)
public class CrudCatalogIntegrationTest {

    @Autowired
    CatalogServiceImpl catalogService;

    @Test
    public void CrudTestCatalog() {
        catalogService.deleteAll();
        CatalogRequest request = new CatalogRequest();
        request.setTitle("Test Catalog");
        CatalogRequest catalogRequest = new CatalogRequest();
        catalogRequest.setTitle("New Test catalog");
        catalogService.edit(catalogService.save(request).getCatalogId(), catalogRequest);
        List<Catalog> catalogs = catalogService.findAll();
        assertEquals(1, catalogs.size());
        System.out.println(catalogs.get(0).getTitle());

    }

}
