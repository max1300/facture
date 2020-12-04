package mre.spring.facture.dto.modelsdto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OtherUserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LienDto lien;
}
