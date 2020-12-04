package mre.spring.facture.services;

import mre.spring.facture.dto.modelsdto.RentreeDto;
import mre.spring.facture.models.Rentree;

import java.util.List;

public interface RentreeServiceInterface {

    Rentree save(RentreeDto rentreeDto);
    Rentree update(Long id, Rentree rentree);
    List<RentreeDto> allRentrees();
    RentreeDto getById(Long id);
    void delete(Rentree rentree);
}
