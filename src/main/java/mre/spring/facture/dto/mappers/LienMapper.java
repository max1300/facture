package mre.spring.facture.dto.mappers;

import mre.spring.facture.dto.modelsdto.LienDto;
import mre.spring.facture.models.Lien;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;

@Mapper(componentModel = "spring")
public interface LienMapper {

    @ValueMappings({
            @ValueMapping(source = "FAMILLE", target = "FAMILLE"),
            @ValueMapping(source = "AMIS", target = "AMIS"),
            @ValueMapping(source = "AUTRES", target = "AUTRES")
    })
    LienDto lienToDto(Lien lien);

    @ValueMappings({
            @ValueMapping(source = "AUTRES", target = "AUTRES"),
            @ValueMapping(source = "FAMILLE", target = "FAMILLE"),
            @ValueMapping(source = "AMIS", target = "AMIS")
    })
    Lien dtoToLien(LienDto lienDto);
}
