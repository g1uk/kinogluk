package com.lisovskiy.kinogluk.service;

import com.lisovskiy.kinogluk.entity.Catalog;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CatalogService {

    List<Catalog> findAll();

    Catalog findByTitle(String title);
    void deleteAll();

    @Transactional
    void deleteByTitle(String title);
}
