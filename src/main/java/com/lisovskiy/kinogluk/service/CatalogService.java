package com.lisovskiy.kinogluk.service;

import com.lisovskiy.kinogluk.entity.Catalog;

import java.util.List;

public interface CatalogService {

    List<Catalog> findAll();
    Catalog save (Catalog catalog);

    Catalog findByTitle(String title);

    void deleteAll();

    void deleteById(int id);
}
