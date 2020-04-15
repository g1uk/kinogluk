package com.lisovskiy.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.service.impl.CatalogServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = KinoglukApplication.class)
public class CrudCatalogIntegrationTest {

    @Autowired
    CatalogServiceImpl catalogService;

    @Test
    public void CrudTestCatalog() {
        //catalogService.deleteAll();
        Catalog catalog = new Catalog();
        catalog.setTitle("Test Catalog");
        catalogService.save(catalog);
//        catalog.setTitle("UpdateTest Catalog");
//        catalogService.save(catalog);
//        List<Catalog> catalogs = catalogService.findAll();
//        assertEquals(1, catalogs.size());
//        System.out.println(catalogs.get(0).getTitle());

    }

    @Test
    public void findByTitleTest() {
        Catalog catalog = catalogService.findByTitle("UpdateTest Catalog");
        System.out.println(catalog.getTitle());
    }

}
