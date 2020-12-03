package mre.spring.facture.repositories;

import mre.spring.facture.models.Rentree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentreeRepository extends JpaRepository<Rentree, Long> {
}
