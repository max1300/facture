package mre.spring.facture.dto.mappers;

import mre.spring.facture.dto.modelsdto.RentreeDto;
import mre.spring.facture.models.Rentree;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface RentreeMapper {

    @Mapping(source = "rentree.category", target = "category")
    RentreeDto rentreeToDto(Rentree rentree);

    @Mapping(source = "category", target = "category")
    Rentree dtoToRentree(RentreeDto rentreeDto);
}
