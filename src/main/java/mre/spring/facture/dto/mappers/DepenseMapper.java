package mre.spring.facture.dto.mappers;

import mre.spring.facture.dto.modelsdto.DepenseDto;
import mre.spring.facture.models.Depense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface DepenseMapper {

    @Mapping(source = "category", target = "category")
    DepenseDto depenseToDto(Depense depense);

    @Mapping(source = "category", target = "category")
    Depense dtoToDepense(DepenseDto depenseDto);
}
