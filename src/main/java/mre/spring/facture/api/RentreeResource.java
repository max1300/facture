package mre.spring.facture.api;

import mre.spring.facture.models.Rentree;
import mre.spring.facture.services.RentreeServiceInterface;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/rentrees")
public class RentreeResource {

    private final RentreeServiceInterface service;

    public RentreeResource(RentreeServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    @Transactional(Transactional.TxType.SUPPORTS)
    public Iterable<Rentree> allRentrees() {
        return service.allRentrees();
    }

    @GetMapping("/{rentreeId}")
    @Transactional(Transactional.TxType.SUPPORTS)
    public Rentree getOne(@PathVariable("rentreeId") Long id) {
        return service.getById(id);
    }

    @PostMapping
    @Transactional(Transactional.TxType.REQUIRED)
    public Rentree create(@RequestBody Rentree rentree) {
        return service.save(rentree);
    }

    @PostMapping("/{rentreeId}")
    @Transactional(Transactional.TxType.REQUIRED)
    public Rentree update(@PathVariable("rentreeId") Long id, Rentree rentree) {
        return service.update(id, rentree);
    }
}
