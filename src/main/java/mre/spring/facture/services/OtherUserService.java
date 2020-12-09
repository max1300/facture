package mre.spring.facture.services;

import lombok.AllArgsConstructor;
import mre.spring.facture.models.OtherUser;
import mre.spring.facture.repositories.OtherUserRepository;
import mre.spring.facture.utils.ServiceUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class OtherUserService implements OtherUserServiceInterface {

    private final OtherUserRepository repository;
    private final ServiceUtils<OtherUser> serviceUtils;

    @Override
    public OtherUser save(OtherUser otherUser) {
        return repository.save(otherUser);
    }

    @Override
    public OtherUser update(Long id, OtherUser otherUser) {
        Optional<OtherUser> optionalOtherUser = repository.findById(id);
        OtherUser otherUserToUpdate = optionalOtherUser.orElse(null);

        otherUserToUpdate = serviceUtils.copyProperties(otherUserToUpdate, otherUser);

        assert otherUserToUpdate != null;
        otherUserToUpdate.setId(id);

        return repository.save(otherUserToUpdate);
    }

    @Override
    public Iterable<OtherUser> allOtherUsers() {
        return repository.findAll();
    }

    @Override
    public OtherUser getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(OtherUser otherUser) {
        repository.delete(otherUser);
    }
}
