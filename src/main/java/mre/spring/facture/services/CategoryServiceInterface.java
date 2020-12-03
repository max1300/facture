package mre.spring.facture.services;

import mre.spring.facture.models.Category;

public interface CategoryServiceInterface {
    Category save(Category category);
    Category update(Long id, Category category);
    Iterable<Category> allCategories();
    Category getById(Long id);
    void delete(Category category);
}
