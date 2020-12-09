package mre.spring.facture.api;

import lombok.AllArgsConstructor;
import mre.spring.facture.dto.mappers.RentreeMapper;
import mre.spring.facture.dto.modelsdto.RentreeDto;
import mre.spring.facture.models.Rentree;
import mre.spring.facture.services.RentreeServiceInterface;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/rentrees")
public class RentreeResource {

    private final RentreeServiceInterface service;
    private final RentreeMapper rentreeMapper;

    @GetMapping
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<RentreeDto> allRentrees() {
        return service.allRentrees().stream()
                .map(rentree -> rentreeMapper.rentreeToDto(rentree))
                .collect(Collectors.toList());
    }

    @GetMapping("/{rentreeId}")
    @Transactional(Transactional.TxType.SUPPORTS)
    public RentreeDto getOne(@PathVariable("rentreeId") Long id) {
        return rentreeMapper.rentreeToDto(service.getById(id));
    }

    @PostMapping
    @Transactional(Transactional.TxType.REQUIRED)
    public Rentree create(@Valid @RequestBody RentreeDto rentreeDto) {
        return service.save(rentreeMapper.dtoToRentree(rentreeDto));
    }

    @PostMapping("/{rentreeId}")
    @Transactional(Transactional.TxType.REQUIRED)
    public Rentree update(@PathVariable("rentreeId") Long id, @Valid @RequestBody Rentree rentree) {
        return service.update(id, rentree);
    }
}
