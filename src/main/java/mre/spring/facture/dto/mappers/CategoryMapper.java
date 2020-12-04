package mre.spring.facture.dto.mappers;

import mre.spring.facture.dto.modelsdto.CategoryDto;
import mre.spring.facture.models.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {RentreeMapper.class, DepenseMapper.class})
public interface CategoryMapper {

    @Mapping(source = "category.depenses", target = "depensesDto")
    @Mapping(source = "category.rentrees", target = "rentreesDto")
    CategoryDto categoryToDto(Category category);

    @InheritInverseConfiguration
    Category dtoToCategory(CategoryDto categoryDto);

}
