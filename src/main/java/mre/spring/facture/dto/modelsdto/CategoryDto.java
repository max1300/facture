package mre.spring.facture.dto.modelsdto;

import java.util.List;

public class CategoryDto {

    private Long id;
    private String nom;
    private String description;
    private String affiliation;
    private List<DepenseDto> depenses;
    private List<RentreeDto> rentrees;

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

    public List<DepenseDto> getDepenses() {
        return depenses;
    }

    public void setDepenses(List<DepenseDto> depenses) {
        this.depenses = depenses;
    }

    public List<RentreeDto> getRentrees() {
        return rentrees;
    }

    public void setRentrees(List<RentreeDto> rentrees) {
        this.rentrees = rentrees;
    }
}
