package com.lisovskiy.kinogluk.service.impl;

import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.entity.Game;
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
        for (Game game : catalog.getGames()
             ) {
            game.setCatalog(catalog);
        }
        entityManager.persist(catalog);
        return catalog;
    }

    @Transactional
    public Catalog update(int id, Catalog catalog) {
        Catalog original = entityManager.find(Catalog.class, id);
        if (original != null) {
            original.setTitle(catalog.getTitle());
            for (Game game : original.getGames()
                 ) {
                entityManager.remove(game);
            }
            original.getGames().clear();
            for (Game game : original.getGames()
                 ) {
                game.setCatalog(original);
                original.getGames().add(game);
                entityManager.persist(game);
            }
            entityManager.merge(original);
        }
        return original;
    }

    @Transactional
    public void delete(int id) {
        Catalog catalog = entityManager.find(Catalog.class, id);
        if (catalog != null) {
            entityManager.remove(catalog);
        }
        else throw new CatalogNotFoundException(id);
    }

    @Override
    public List<Catalog> findAll() {
        return catalogRepository.findAll();
    }

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

    @Override
    @Transactional
    public void deleteByTitle(String title) {
        catalogRepository.deleteByTitle(title);
    }


}
