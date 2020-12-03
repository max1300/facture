package mre.spring.facture.dto.mappers;

import mre.spring.facture.dto.modelsdto.CategoryDto;
import mre.spring.facture.models.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {RentreeMapper.class, DepenseMapper.class})
public interface CategoryMapper {

    @Mapping(source = "category.depenses", target = "depenses")
    @Mapping(source = "category.rentrees", target = "rentrees")
    CategoryDto categoryToDto(Category category);
    Category dtoToCategory(CategoryDto categoryDto);

}
