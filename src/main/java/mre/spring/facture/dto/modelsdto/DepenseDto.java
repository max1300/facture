package mre.spring.facture.dto.modelsdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import mre.spring.facture.models.Account;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class DepenseDto {

    private Long id;

    @NotNull(message = "le montant ne peut être nul")
    @Positive(message = "le montant de la rentree d'argent doit au minimum être de 1 euros")
    private Double montant;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    @Size(min = 10, max = 255,
            message = "la description doit contenir suffisamment d'indications")
    @NotEmpty
    private String description;

    @Valid
    private CategoryDto categoryDto;

    @Valid
    @JsonIgnoreProperties({"depenses", "rentrees"})
    private Account accountDto;

    public DepenseDto() {
    }

    public DepenseDto(Long id, @NotNull(message = "le montant ne peut être nul") @Positive(message = "le montant de la rentree d'argent doit au minimum être de 1 euros") Double montant, LocalDate date, @Size(min = 10, max = 255,
            message = "la description doit contenir suffisamment d'indications") @NotEmpty String description, @Valid CategoryDto categoryDto, @Valid Account accountDto) {
        this.id = id;
        this.montant = montant;
        this.date = date;
        this.description = description;
        this.categoryDto = categoryDto;
        this.accountDto = accountDto;
    }
}
