package mre.spring.facture.dto.modelsdto;

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
    private String name;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdAt;

//    @ManyToOne
//    private ApiUser apiUser;

    @Valid
    private Set<Depense> depenses = new HashSet<>();
    @Valid
    private Set<Rentree> rentrees = new HashSet<>();

    public AccountDto() {
    }

    public AccountDto(Long id, @NotEmpty @NotNull String name, LocalDate createdAt, @Valid Set<Depense> depenses, @Valid Set<Rentree> rentrees) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.depenses = depenses;
        this.rentrees = rentrees;
    }
}
