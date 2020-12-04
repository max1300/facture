package mre.spring.facture.dto.modelsdto;

import java.util.List;

public class CategoryDto {

    private Long id;
    private String nom;
    private String description;
    private List<DepenseDto> depensesDto;
    private List<RentreeDto> rentreesDto;

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

    public List<DepenseDto> getDepensesDto() {
        return depensesDto;
    }

    public void setDepensesDto(List<DepenseDto> depensesDto) {
        this.depensesDto = depensesDto;
    }

    public List<RentreeDto> getRentreesDto() {
        return rentreesDto;
    }

    public void setRentreesDto(List<RentreeDto> rentreesDto) {
        this.rentreesDto = rentreesDto;
    }
}
