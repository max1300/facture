package mre.spring.facture.api;

import lombok.AllArgsConstructor;
import mre.spring.facture.dto.mappers.RentreeMapper;
import mre.spring.facture.dto.modelsdto.RentreeDto;
import mre.spring.facture.models.Rentree;
import mre.spring.facture.services.RentreeServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/rentrees")
public class RentreeResource {

    private final RentreeServiceInterface service;
    private final RentreeMapper rentreeMapper;

    @GetMapping
    @Transactional(Transactional.TxType.SUPPORTS)
    public ResponseEntity<RentreeDto> allRentrees() {
        List<RentreeDto> collect = service.allRentrees().stream()
                .map(rentreeMapper::rentreeToDto)
                .collect(Collectors.toList());

        return new ResponseEntity(collect, HttpStatus.OK);
    }

    @GetMapping("/{rentreeId}")
    @Transactional(Transactional.TxType.SUPPORTS)
    public ResponseEntity<RentreeDto> getOne(@PathVariable("rentreeId") Long id) {
        RentreeDto rentreeDto = rentreeMapper.rentreeToDto(service.getById(id));
        return new ResponseEntity(rentreeDto, HttpStatus.OK);
    }

    @PostMapping
    @Transactional(Transactional.TxType.REQUIRED)
    public ResponseEntity<Rentree> create(@Valid @RequestBody RentreeDto rentreeDto) {
        Rentree save = service.save(rentreeMapper.dtoToRentree(rentreeDto));
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @PostMapping("/{rentreeId}")
    @Transactional(Transactional.TxType.REQUIRED)
    public ResponseEntity<Rentree> update(@PathVariable("rentreeId") Long id, @Valid @RequestBody Rentree rentree) {
        Rentree update = service.update(id, rentree);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }
}
