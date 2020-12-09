package mre.spring.facture.repositories;

import mre.spring.facture.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByNom(String nom);
}
