package mre.spring.facture.services;

import mre.spring.facture.models.Entreprise;

public interface EntrepriseServiceInterface {

    Entreprise save(Entreprise entreprise);
    Entreprise update(Long id, Entreprise entreprise);
    Iterable<Entreprise> allEntreprises();
    Entreprise getById(Long id);
    void delete(Entreprise entreprise);
}
