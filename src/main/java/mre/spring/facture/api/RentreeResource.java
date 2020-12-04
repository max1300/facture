package mre.spring.facture.api;

import lombok.AllArgsConstructor;
import mre.spring.facture.dto.modelsdto.RentreeDto;
import mre.spring.facture.models.Rentree;
import mre.spring.facture.services.RentreeServiceInterface;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/rentrees")
public class RentreeResource {

    private final RentreeServiceInterface service;


    @GetMapping
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<RentreeDto> allRentrees() {
        return service.allRentrees();
    }

    @GetMapping("/{rentreeId}")
    @Transactional(Transactional.TxType.SUPPORTS)
    public RentreeDto getOne(@PathVariable("rentreeId") Long id) {
        return service.getById(id);
    }

    @PostMapping
    @Transactional(Transactional.TxType.REQUIRED)
    public Rentree create(@RequestBody RentreeDto rentreeDto) {
        return service.save(rentreeDto);
    }

    @PostMapping("/{rentreeId}")
    @Transactional(Transactional.TxType.REQUIRED)
    public Rentree update(@PathVariable("rentreeId") Long id, Rentree rentree) {
        return service.update(id, rentree);
    }
}
