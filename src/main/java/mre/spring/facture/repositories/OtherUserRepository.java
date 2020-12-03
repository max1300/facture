package mre.spring.facture.repositories;

import mre.spring.facture.models.OtherUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtherUserRepository extends JpaRepository<OtherUser, Long> {
}
