package mre.spring.facture.repositories;

import mre.spring.facture.models.Depense;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepenseRepository extends JpaRepository<Depense, Long> {

    @EntityGraph(value = "depense.loadCategory", type = EntityGraph.EntityGraphType.FETCH)
    List<Depense> findAll();

    @EntityGraph(value = "depense.loadCategory", type = EntityGraph.EntityGraphType.FETCH)
    Optional<Depense> findById(Long id);
}
