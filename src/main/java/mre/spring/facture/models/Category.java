package mre.spring.facture.models;


import javax.persistence.*;
import java.util.List;

@Entity
public class Category{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private String affiliation;

    @OneToMany(mappedBy = "category")
    private List<Depense> depenses;

    @OneToMany(mappedBy = "category")
    private List<Rentree> rentrees;

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

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
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
