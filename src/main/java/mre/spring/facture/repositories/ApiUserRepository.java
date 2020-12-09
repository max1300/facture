package mre.spring.facture.repositories;

import mre.spring.facture.models.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiUserRepository extends JpaRepository<ApiUser, Long> {
}
