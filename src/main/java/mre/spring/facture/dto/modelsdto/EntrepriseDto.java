package mre.spring.facture.dto.modelsdto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class EntrepriseDto {

    private Long id;

    @NotEmpty(message = "le nom ne peut pas être omis")
    @Size(min = 5, message = "le nom doit au moins contenir 5 caractères")
    private String nom;
}
