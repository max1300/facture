package mre.spring.facture.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = "le champ username doit être rempli")
    private String username;

    @NotBlank(message = "le champ password doit être rempli")
    @Size(min = 8)
    private String password;
}
