package mre.spring.facture.dto.mappers;

import mre.spring.facture.dto.modelsdto.CategoryDto;
import mre.spring.facture.models.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto categoryToDto(Category category);

    @InheritInverseConfiguration
    Category dtoToCategory(CategoryDto categoryDto);

}
