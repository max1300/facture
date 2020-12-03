package mre.spring.facture.dto.mappers;

import mre.spring.facture.dto.modelsdto.EntrepriseDto;
import mre.spring.facture.models.Entreprise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntrepriseMapper {

    EntrepriseDto entrepriseToDto(Entreprise entreprise);
    Entreprise dtoToEntreprise(EntrepriseDto entrepriseDto);
}
