package mre.spring.facture.dto.mappers;

import mre.spring.facture.dto.modelsdto.RentreeDto;
import mre.spring.facture.models.Rentree;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, AccountMapper.class})
public interface RentreeMapper {

    @Mapping(source = "category", target = "categoryDto")
    @Mapping(source = "amount", target = "montant")
    @Mapping(source = "date", target = "date", dateFormat = "dd/MMM/yyyy")
    @Mapping(source = "account", target = "accountDto")
    RentreeDto rentreeToDto(Rentree rentree);

    @InheritInverseConfiguration
    Rentree dtoToRentree(RentreeDto rentreeDto);
}
