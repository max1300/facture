package mre.spring.facture.dto.modelsdto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class RentreeDto {

    private Long id;
    private Double amount;
    private Instant date;
    private String description;
    private CategoryDto categoryDto;
}
