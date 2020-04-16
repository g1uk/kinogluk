package com.lisovskiy.kinogluk.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "companies", schema = "games_db")
public class Company {

    @Id
    @NotNull
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private int companyId;

    @NotNull
    @Column(name = "title", length = 50)
    private String title;

    @OneToMany(mappedBy = "company")
    private List<Game> games;

    public Company() {
    }

    public Company(String title) {
        this.title = title;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String company) {
        this.title = company;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company1 = (Company) o;
        return companyId == company1.companyId &&
                title.equals(company1.title) &&
                games.equals(company1.games);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, title, games);
    }
}
