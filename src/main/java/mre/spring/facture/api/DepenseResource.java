package mre.spring.facture.api;

import lombok.AllArgsConstructor;
import mre.spring.facture.dto.mappers.DepenseMapper;
import mre.spring.facture.dto.modelsdto.DepenseDto;
import mre.spring.facture.models.Depense;
import mre.spring.facture.services.DepenseServiceInterface;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/depenses")
public class DepenseResource {

    private final DepenseServiceInterface service;
    private final DepenseMapper depenseMapper;

    @GetMapping
    public List<DepenseDto> allDepenses() {
        return service.allDepenses();
    }

    @GetMapping("/{depenseId}")
    public DepenseDto getOne(@PathVariable("depenseId") Long id) {
        return service.getById(id);
    }

    @PostMapping
    @Transactional(Transactional.TxType.REQUIRED)
    public Depense create(@RequestBody DepenseDto depenseDto) {
        return service.save(depenseDto);
    }

    @PostMapping("/{depenseId}")
    @Transactional(Transactional.TxType.REQUIRED)
    public Depense update(@PathVariable("depenseId") Long id, Depense depense) {
        return service.update(id, depense);
    }
}
