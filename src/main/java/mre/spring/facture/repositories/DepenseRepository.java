package mre.spring.facture.repositories;

import mre.spring.facture.models.Depense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepenseRepository extends JpaRepository<Depense, Long> {
}
