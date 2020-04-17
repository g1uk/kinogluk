package com.lisovskiy.kinogluk.service;

import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.request.CatalogRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CatalogService {

    Catalog save (CatalogRequest request);
    Catalog edit(int id, CatalogRequest request);
    Catalog findByTitle(String title);
    List<Catalog> findAll();
    void deleteAll();
    void deleteById(int id);

    @Transactional
    void deleteByTitle(String title);
}
