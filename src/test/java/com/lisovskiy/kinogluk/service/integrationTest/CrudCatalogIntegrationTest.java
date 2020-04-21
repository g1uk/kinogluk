package com.lisovskiy.kinogluk.service.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.entity.Catalog;
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
        Catalog catalog = new Catalog();
        catalog.setTitle("Test Catalog");
        Catalog catalog1 = new Catalog();
        catalog1.setTitle("New Test catalog");
        catalogService.update(catalogService.create(catalog).getCatalogId(), catalog1);
        List<Catalog> catalogs = catalogService.findAll();
        assertEquals(1, catalogs.size());
        System.out.println(catalogs.get(0).getTitle());

    }

}
