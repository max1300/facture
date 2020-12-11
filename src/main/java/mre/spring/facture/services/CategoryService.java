package mre.spring.facture.services;

import lombok.AllArgsConstructor;
import mre.spring.facture.exception.ObjectNotFoundException;
import mre.spring.facture.models.Category;
import mre.spring.facture.repositories.CategoryRepository;
import mre.spring.facture.utils.ServiceUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryService implements CategoryServiceInterface{

    private final CategoryRepository categoryRepository;
    private final ServiceUtils<Category> serviceUtils;

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Long id, Category category) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        Category categoryToUpdate = optionalCategory.orElseThrow(
                ()-> new ObjectNotFoundException("Category with id : " + id + " not found"));

        categoryToUpdate = serviceUtils.copyProperties(categoryToUpdate, category);

        assert categoryToUpdate != null;
        categoryToUpdate.setId(id);

        return categoryRepository.save(categoryToUpdate);
    }

    @Override
    public Iterable<Category> allCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id).orElseThrow(
                ()-> new ObjectNotFoundException("Category with id : " + id + " not found"));
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }
}
