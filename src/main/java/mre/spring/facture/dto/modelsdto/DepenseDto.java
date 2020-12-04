package mre.spring.facture.dto.modelsdto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class DepenseDto {

    private Long id;
    private Double montant;
    private Instant date;
    private String description;
    private CategoryDto categoryDto;
}
