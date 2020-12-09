package mre.spring.facture.repositories;

import mre.spring.facture.models.Rentree;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RentreeRepository extends JpaRepository<Rentree, Long> {

    @EntityGraph(value = "rentree.loadCategory", type = EntityGraph.EntityGraphType.FETCH)
    List<Rentree> findAll();

    @EntityGraph(value = "rentree.loadCategory", type = EntityGraph.EntityGraphType.FETCH)
    Optional<Rentree> findById(Long id);
}
