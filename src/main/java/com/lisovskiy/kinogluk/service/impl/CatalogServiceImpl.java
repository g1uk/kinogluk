package com.lisovskiy.kinogluk.service.impl;

import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.exceptions.CatalogNotFoundException;
import com.lisovskiy.kinogluk.repository.CatalogRepository;
import com.lisovskiy.kinogluk.service.CatalogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;

    public CatalogServiceImpl (CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public List<Catalog> findAll() { return catalogRepository.findAll(); }

    @Override
    public Catalog save (Catalog catalog) {
        return catalogRepository.save(catalog);
    }

    @Override
    public Catalog findByTitle(String title) {
        Catalog catalog = catalogRepository.findByTitle(title);
        if (catalog == null) {
            throw new CatalogNotFoundException(title);
        }
        return catalog;
    }

    @Override
    public void deleteAll() { catalogRepository.deleteAll(); };

    @Override
    public void deleteById(int id) {
        if (!catalogRepository.existsById(id)) {
            throw new CatalogNotFoundException(id);
        }
        catalogRepository.deleteById(id);
    }


}
