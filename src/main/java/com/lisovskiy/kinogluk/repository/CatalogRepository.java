package com.lisovskiy.kinogluk.repository;

import com.lisovskiy.kinogluk.entity.Catalog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CatalogRepository extends CrudRepository <Catalog, Integer> {

    List<Catalog> findAll();

    Catalog findByTitle (String title);

    @Transactional
    void deleteByTitle (String title);

}
