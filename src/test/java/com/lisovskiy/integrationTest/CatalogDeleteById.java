package com.lisovskiy.integrationTest;

import com.lisovskiy.kinogluk.KinoglukApplication;
import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.service.impl.CatalogServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = KinoglukApplication.class)
public class CatalogDeleteById {

    @Autowired
    CatalogServiceImpl catalogService;

    @Test
    public void deleteByIdTest() {
        List<Catalog> catalogs = catalogService.findAll();
        catalogService.deleteById(catalogs.get(1).getCatalogId());
        assertEquals(1, catalogs.size()-1);
    }
}
