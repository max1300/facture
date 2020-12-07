package mre.spring.facture.dto.modelsdto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class OtherUserDto {

    private Long id;

    @NotEmpty(message = "le prénom ne peut pas être omis")
    @Size(min = 5, message = "le prenom doit au moins contenir 5 caractères")
    private String firstName;

    @NotEmpty(message = "le nom ne peut pas être omis")
    @Size(min = 5, message = "le nom doit au moins contenir 5 caractères")
    private String lastName;

    @Email(message = "l'email doit être valide")
    private String email;

    private LienDto lien;
}
