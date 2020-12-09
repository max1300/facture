package mre.spring.facture.services;

import lombok.AllArgsConstructor;
import mre.spring.facture.models.Entreprise;
import mre.spring.facture.repositories.EntrepriseRepository;
import mre.spring.facture.utils.ServiceUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class EntrepriseService implements EntrepriseServiceInterface {

    private final EntrepriseRepository repository;
    private final ServiceUtils<Entreprise> serviceUtils;

    @Override
    public Entreprise save(Entreprise entreprise) {
        return repository.save(entreprise);
    }

    @Override
    public Entreprise update(Long id, Entreprise entreprise) {
        Optional<Entreprise> optionalEntreprise = repository.findById(id);
        Entreprise entrepriseToUpdate = optionalEntreprise.orElse(null);

        entrepriseToUpdate = serviceUtils.copyProperties(entrepriseToUpdate, entreprise);

        assert entrepriseToUpdate != null;
        entrepriseToUpdate.setId(id);

        return repository.save(entrepriseToUpdate);
    }

    @Override
    public Iterable<Entreprise> allEntreprises() {
        return repository.findAll();
    }

    @Override
    public Entreprise getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Entreprise entreprise) {
        repository.delete(entreprise);
    }
}
