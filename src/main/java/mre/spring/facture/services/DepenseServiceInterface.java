package mre.spring.facture.services;

import mre.spring.facture.dto.modelsdto.DepenseDto;
import mre.spring.facture.models.Depense;

import java.util.List;

public interface DepenseServiceInterface {

    Depense save(DepenseDto depenseDto);
    Depense update(Long id, Depense depense);
    List<DepenseDto> allDepenses();
    DepenseDto getById(Long id);
    void delete(Depense depense);
}
