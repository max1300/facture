package mre.spring.facture.services;

import mre.spring.facture.dto.modelsdto.RentreeDto;
import mre.spring.facture.models.Rentree;

import java.util.List;

public interface RentreeServiceInterface {

    Rentree save(Rentree rentree);
    Rentree update(Long id, Rentree rentree);
    List<Rentree> allRentrees();
    Rentree getById(Long id);
    void delete(Rentree rentree);
}
