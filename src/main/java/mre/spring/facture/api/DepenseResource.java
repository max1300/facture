package mre.spring.facture.api;

import lombok.AllArgsConstructor;
import mre.spring.facture.dto.mappers.DepenseMapper;
import mre.spring.facture.dto.modelsdto.DepenseDto;
import mre.spring.facture.models.Depense;
import mre.spring.facture.services.DepenseServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/depenses")
public class DepenseResource {

    private final DepenseServiceInterface service;
    private final DepenseMapper depenseMapper;

    @GetMapping
    public ResponseEntity<DepenseDto> allDepenses() {
        List<DepenseDto> collect = service.allDepenses().stream()
                .map(depenseMapper::depenseToDto)
                .collect(Collectors.toList());
        return new ResponseEntity(collect, HttpStatus.OK);
    }

    @GetMapping("/{depenseId}")
    public ResponseEntity<DepenseDto> getOne(@PathVariable("depenseId") Long id) {
        DepenseDto depenseDto = depenseMapper.depenseToDto(service.getById(id));
        return new ResponseEntity<>(depenseDto, HttpStatus.OK);

    }

    @PostMapping
    @Transactional(Transactional.TxType.REQUIRED)
    public ResponseEntity<Depense> create(@Valid @RequestBody DepenseDto depenseDto) {
        Depense save = service.save(depenseMapper.dtoToDepense(depenseDto));
        return new ResponseEntity(save, HttpStatus.CREATED);
    }

    @PostMapping("/{depenseId}")
    @Transactional(Transactional.TxType.REQUIRED)
    public ResponseEntity<Depense> update(@PathVariable("depenseId") Long id, @Valid @RequestBody Depense depense) {
        Depense update = service.update(id, depense);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }
}
