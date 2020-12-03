package mre.spring.facture.dto.mappers;

import mre.spring.facture.dto.modelsdto.OtherUserDto;
import mre.spring.facture.models.OtherUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {LienMapper.class})
public interface OtherUserMapper {

    @Mapping(source = "lien", target = "lien")
    OtherUserDto otherUserToDto(OtherUser otherUser);

    @Mapping(source = "lien", target = "lien")
    OtherUser dtoToOtherUser(OtherUserDto otherUserDto);
}
