package com.lisovskiy.kinogluk.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "companies", schema = "games_db")
public class Company {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "company_id", nullable = false)
    private int companyId;

    @Column(name = "company", nullable = false, length = 50)
    private String company;

    @OneToMany(mappedBy = "company")
    private List<Game> games;

    public Company() {
    }

    public Company(String company) {
        this.company = company;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getCompanyId() {
        return companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company1 = (Company) o;
        return companyId == company1.companyId &&
                company.equals(company1.company) &&
                games.equals(company1.games);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, company, games);
    }
}
