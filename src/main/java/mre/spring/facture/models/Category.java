package mre.spring.facture.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Depense> depenses = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    private List<Rentree> rentrees = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Depense> getDepenses() {
        return depenses;
    }

    public void setDepenses(List<Depense> depenses) {
        this.depenses = depenses;
    }

    public List<Rentree> getRentrees() {
        return rentrees;
    }

    public void setRentrees(List<Rentree> rentrees) {
        this.rentrees = rentrees;
    }
}
