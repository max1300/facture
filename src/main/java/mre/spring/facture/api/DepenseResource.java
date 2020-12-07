package mre.spring.facture.api;

import lombok.AllArgsConstructor;
import mre.spring.facture.dto.mappers.DepenseMapper;
import mre.spring.facture.dto.modelsdto.DepenseDto;
import mre.spring.facture.models.Depense;
import mre.spring.facture.services.DepenseServiceInterface;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/depenses")
public class DepenseResource {

    private final DepenseServiceInterface service;
    private final DepenseMapper depenseMapper;

    @GetMapping
    public List<DepenseDto> allDepenses() {
        return service.allDepenses().stream()
                .map(depenseMapper::depenseToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{depenseId}")
    public DepenseDto getOne(@PathVariable("depenseId") Long id) {
        return depenseMapper.depenseToDto(service.getById(id));
    }

    @PostMapping
    @Transactional(Transactional.TxType.REQUIRED)
    public Depense create(@Valid @RequestBody DepenseDto depenseDto) {
        return service.save(depenseMapper.dtoToDepense(depenseDto));
    }

    @PostMapping("/{depenseId}")
    @Transactional(Transactional.TxType.REQUIRED)
    public Depense update(@PathVariable("depenseId") Long id, @Valid @RequestBody Depense depense) {
        return service.update(id, depense);
    }
}
