package mre.spring.facture.services;

import lombok.AllArgsConstructor;
import mre.spring.facture.dto.mappers.DepenseMapper;
import mre.spring.facture.dto.modelsdto.DepenseDto;
import mre.spring.facture.models.Depense;
import mre.spring.facture.repositories.DepenseRepository;
import mre.spring.facture.utils.ServiceUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DepenseService implements DepenseServiceInterface{

    private final DepenseRepository depenseRepository;
    private final ServiceUtils<Depense> serviceUtils;

    @Override
    public Depense save(Depense depense) {
        return depenseRepository.save(depense);
    }

    @Override
    public Depense update(Long id, Depense depense) {
        Optional<Depense> optionalDepense = depenseRepository.findById(id);
        Depense depenseToUpdate = optionalDepense.orElse(null);

        depenseToUpdate = serviceUtils.copyProperties(depenseToUpdate, depense);

        assert depenseToUpdate != null;
        depenseToUpdate.setId(id);

        return depenseRepository.save(depenseToUpdate);
    }

    @Override
    public List<Depense> allDepenses() {
        return depenseRepository.findAll();
    }

    @Override
    public Depense getById(Long id) {
        return depenseRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Depense depense) {
        depenseRepository.delete(depense);
    }
}
