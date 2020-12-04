package mre.spring.facture.dto.mappers;

import mre.spring.facture.dto.modelsdto.DepenseDto;
import mre.spring.facture.models.Depense;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface DepenseMapper {

    @Mapping(source = "category", target = "categoryDto")
    @Mapping(source = "amount", target = "montant")
    @Mapping(source = "date", target = "date", dateFormat = "dd/MMM/yyyy")
    DepenseDto depenseToDto(Depense depense);

    @InheritInverseConfiguration
    Depense dtoToDepense(DepenseDto depenseDto);
}
