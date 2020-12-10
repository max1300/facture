package mre.spring.facture.dto.modelsdto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiUserDto {

    private Long id;
    private String username;
    private String email;

}
