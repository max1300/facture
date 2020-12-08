package mre.spring.facture.repositories;

import mre.spring.facture.models.Account;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @EntityGraph(value = "account.loadDepensesAndRentree", type = EntityGraph.EntityGraphType.FETCH)
    List<Account> findAll();

    @EntityGraph(value = "account.loadDepensesAndRentree", type = EntityGraph.EntityGraphType.FETCH)
    Optional<Account> findById(Long id);
}
