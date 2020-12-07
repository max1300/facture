package mre.spring.facture.dto.modelsdto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
public class RentreeDto {

    private Long id;
    private Double amount;
    private Instant date;
    private String description;
    private CategoryDto categoryDto;

    public RentreeDto() {
    }

    public RentreeDto(Long id, Double amount, Instant date, String description, CategoryDto categoryDto) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.categoryDto = categoryDto;
    }
}
