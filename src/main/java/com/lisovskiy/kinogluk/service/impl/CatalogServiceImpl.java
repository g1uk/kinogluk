package com.lisovskiy.kinogluk.service.impl;

import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.entity.Game;
import com.lisovskiy.kinogluk.exceptions.CatalogNotFoundException;
import com.lisovskiy.kinogluk.repository.CatalogRepository;
import com.lisovskiy.kinogluk.request.CatalogRequest;
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
        for (Game game : catalog.getGames()
             ) {
            game.setCatalog(catalog);
        }
        entityManager.persist(catalog);
        return catalog;
    }

    @Override
    public List<Catalog> findAll() {
        return catalogRepository.findAll();
    }

    @Override
    public Catalog save(CatalogRequest request) {
        Catalog catalog = new Catalog();
        catalog.setTitle(request.getTitle());
        return catalogRepository.save(catalog);
    }

    @Override
    public Catalog edit (int id, CatalogRequest request) {
        if (!catalogRepository.existsById(id)) {
            throw new CatalogNotFoundException(id);
        }
        Catalog catalog = new Catalog();
        catalog.setCatalogId(id);
        catalog.setTitle(request.getTitle());
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

    @Override
    @Transactional
    public void deleteByTitle(String title) {
        catalogRepository.deleteByTitle(title);
    }


}
