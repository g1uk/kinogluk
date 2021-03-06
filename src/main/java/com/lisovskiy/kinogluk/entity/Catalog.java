package com.lisovskiy.kinogluk.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "catalog", schema = "games_db")
public class Catalog {
    @Id
    @NotNull
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "catalog_id")
    private int catalogId;

    @Basic
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "catalog",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Game> games;

    public Catalog() {
    }

    public List<Game> getGames() {
        return games;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalog catalog = (Catalog) o;
        return catalogId == catalog.catalogId &&
                title.equals(catalog.title) &&
                games.equals(catalog.games);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalogId, title, games);
    }
}
