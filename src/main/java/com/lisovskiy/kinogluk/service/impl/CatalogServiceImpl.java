package com.lisovskiy.kinogluk.service.impl;

import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.exceptions.CatalogDoesNotExistsException;
import com.lisovskiy.kinogluk.exceptions.CatalogIsAlreadyExistsException;
import com.lisovskiy.kinogluk.exceptions.CatalogNotFoundException;
import com.lisovskiy.kinogluk.repository.CatalogRepository;
import com.lisovskiy.kinogluk.service.CatalogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @PersistenceContext
    EntityManager entityManager;

    private final CatalogRepository catalogRepository;

    public CatalogServiceImpl (CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Transactional
    public Catalog create(Catalog catalog) {
        List<Catalog> catalogs = catalogRepository.findAll();
        for (Catalog temp : catalogs
             ) {
            if (temp.getTitle().equals(catalog.getTitle())) {
                throw new CatalogIsAlreadyExistsException(catalog.getTitle());
            } else entityManager.persist(catalog);
        }
        return catalog;
    }

    @Transactional
    public Catalog update(int id, Catalog catalog) {
        Catalog original = entityManager.find(Catalog.class, id);
        if (original != null) {
            original.setTitle(catalog.getTitle());
            entityManager.merge(original);
        } else throw new CatalogDoesNotExistsException(id);
        return original;
    }

    @Transactional
    public void delete(int id) {
        Catalog catalog = entityManager.find(Catalog.class, id);
        if (catalog != null) {
            entityManager.remove(catalog);
        }
        else throw new CatalogDoesNotExistsException(id);
    }

    @Override
    public List<Catalog> findAll() {
        return catalogRepository.findAll();
    }

    @Override
    public Catalog findByTitle(String title) {
        Catalog catalog = catalogRepository.findByTitle(title);
        if (catalog == null) {
            throw new CatalogNotFoundException(title);
        }
        return catalog;
    }

    public void deleteAll() { catalogRepository.deleteAll(); };

    @Override
    @Transactional
    public void deleteByTitle(String title) {
        List<Catalog> catalogs = catalogRepository.findAll();
        for (Catalog temp : catalogs
             ) {
            if (temp.getTitle().equals(title)) {
                catalogRepository.deleteByTitle(title);
            } else throw new CatalogDoesNotExistsException(title);
        }

    }


}
