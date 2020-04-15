package com.lisovskiy.kinogluk.repository;

import com.lisovskiy.kinogluk.entity.Catalog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogRepository extends CrudRepository <Catalog, Integer> {

    List<Catalog> findAll();

    Catalog save (Catalog catalog);

    Catalog findByTitle (String title);

    void deleteById (int id);
}
