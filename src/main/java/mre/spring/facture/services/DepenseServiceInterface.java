package mre.spring.facture.services;

import mre.spring.facture.models.Depense;

import java.util.List;

public interface DepenseServiceInterface {

    Depense save(Depense depense);
    Depense update(Long id, Depense depense);
    List<Depense> allDepenses();
    Depense getById(Long id);
    void delete(Depense depense);
}
