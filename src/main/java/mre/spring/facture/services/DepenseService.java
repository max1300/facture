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
    private final DepenseMapper depenseMapper;

    @Override
    public Depense save(DepenseDto depenseDto) {
        return depenseRepository.save(depenseMapper.dtoToDepense(depenseDto));
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
    public List<DepenseDto> allDepenses() {
        List<DepenseDto> depenseDtos = depenseRepository.findAll()
                .stream()
                .map(depenseMapper::depenseToDto)
                .collect(Collectors.toList());

        return depenseDtos;

    }

    @Override
    public DepenseDto getById(Long id) {
        return depenseMapper.depenseToDto(depenseRepository.findById(id).orElse(null));
    }

    @Override
    public void delete(Depense depense) {
        depenseRepository.delete(depense);
    }
}
