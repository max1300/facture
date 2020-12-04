package mre.spring.facture.dto.modelsdto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDto {

    private Long id;
    private String nom;
    private String description;
    private List<DepenseDto> depensesDto;
    private List<RentreeDto> rentreesDto;
}
