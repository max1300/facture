package mre.spring.facture.services;

import mre.spring.facture.models.Rentree;

public interface RentreeServiceInterface {

    Rentree save(Rentree rentree);
    Rentree update(Long id, Rentree rentree);
    Iterable<Rentree> allRentrees();
    Rentree getById(Long id);
    void delete(Rentree rentree);
}
