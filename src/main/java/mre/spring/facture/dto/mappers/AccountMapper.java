package mre.spring.facture.dto.mappers;

import mre.spring.facture.dto.modelsdto.AccountDto;
import mre.spring.facture.models.Account;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {RentreeMapper.class, DepenseMapper.class})
public interface AccountMapper {

    @Mapping(source = "createdAt", target = "createdAt", dateFormat = "dd/MMM/yyyy")
    @Mapping(source = "depenses", target = "depenses")
    @Mapping(source = "rentrees", target = "rentrees")
    AccountDto accountToDto(Account account);

    @InheritInverseConfiguration
    Account dtoToAccount(AccountDto accountDto);
}
