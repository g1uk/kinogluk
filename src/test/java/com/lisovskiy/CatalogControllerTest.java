package com.lisovskiy;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.controller.CatalogController;
import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.repository.CatalogRepository;
import com.lisovskiy.kinogluk.service.impl.CatalogServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = KinoglukApplication.class)
public class CatalogControllerTest {

    @Autowired
    CatalogServiceImpl catalogService;

    @Autowired
    CatalogRepository catalogRepository;

    private Catalog createRandomCatalog() {
        Catalog catalog = new Catalog();
        //catalog.setFavourites((int) Math.random() * 9);
        return catalog;
    }

    @Test
    public void findAllTest() {
        CatalogController catalogController = new CatalogController(new CatalogServiceImpl(catalogRepository));
        assertEquals(catalogRepository.findAll(), catalogController.findAll());
    }

    @Test
    public void saveTest() {
        Catalog catalog = createRandomCatalog();
        CatalogController catalogController = new CatalogController(new CatalogServiceImpl(catalogRepository));
        assertEquals(catalog, catalogController.add(catalog));
    }


}
