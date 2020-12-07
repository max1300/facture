package mre.spring.facture.dto.modelsdto;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
public class DepenseDto {

    private Long id;
    private Double montant;
    private Instant date;
    private String description;
    private CategoryDto categoryDto;

    public DepenseDto() {
    }

    public DepenseDto(Long id, Double montant, Instant date, String description, CategoryDto categoryDto) {
        this.id = id;
        this.montant = montant;
        this.date = date;
        this.description = description;
        this.categoryDto = categoryDto;
    }
}
