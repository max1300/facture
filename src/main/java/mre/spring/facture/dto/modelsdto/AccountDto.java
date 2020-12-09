package mre.spring.facture.dto.modelsdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import mre.spring.facture.models.Depense;
import mre.spring.facture.models.Rentree;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class AccountDto {

    private Long id;

    @NotEmpty
    @NotNull
    private String nom;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdAt;

//    @ManyToOne
//    private ApiUser apiUser;

    @Valid
    @JsonIgnoreProperties({"account"})
    private Set<DepenseDto> depenses = new HashSet<>();
    @Valid
    @JsonIgnoreProperties({"account"})
    private Set<RentreeDto> rentrees = new HashSet<>();

    public AccountDto() {
    }

    public AccountDto(Long id, @NotEmpty @NotNull String nom, LocalDate createdAt, @Valid Set<DepenseDto> depenses, @Valid Set<RentreeDto> rentrees) {
        this.id = id;
        this.nom = nom;
        this.createdAt = createdAt;
        this.depenses = depenses;
        this.rentrees = rentrees;
    }
}
