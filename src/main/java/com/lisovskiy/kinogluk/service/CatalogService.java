package com.lisovskiy.kinogluk.service;

import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.request.CatalogRequest;

import java.util.List;

public interface CatalogService {

    List<Catalog> findAll();

    Catalog save (CatalogRequest request);

    Catalog edit(int id, CatalogRequest request);

    Catalog findByTitle(String title);

    void deleteAll();

    void deleteById(int id);
}
