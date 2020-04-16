package com.lisovskiy.kinogluk.request;

import com.lisovskiy.kinogluk.entity.Catalog;
import com.lisovskiy.kinogluk.entity.Company;

import java.time.LocalDate;

public class GameRequest {

    private String title;
    private int rating;
    private LocalDate releaseYear;
    private String shortDescription;
    private Catalog catalog;
    private Company company;

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(LocalDate releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
