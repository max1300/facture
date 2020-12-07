package mre.spring.facture.dto.modelsdto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.Instant;

@Getter
@Setter
@Builder
public class DepenseDto {

    private Long id;

    @NotNull(message = "le montant ne peut être nul")
    @Positive(message = "le montant de la rentree d'argent doit au minimum être de 1 euros")
    private Double montant;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Instant date;

    @Size(min = 10, max = 255,
            message = "la description doit contenir suffisamment d'indications")
    @NotEmpty
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
