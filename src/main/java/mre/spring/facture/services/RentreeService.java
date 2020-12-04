package mre.spring.facture.services;

import mre.spring.facture.dto.mappers.RentreeMapper;
import mre.spring.facture.dto.modelsdto.RentreeDto;
import mre.spring.facture.models.Rentree;
import mre.spring.facture.repositories.RentreeRepository;
import mre.spring.facture.utils.ServiceUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RentreeService implements RentreeServiceInterface {

    private final RentreeRepository rentreeRepository;
    private final ServiceUtils<Rentree> serviceUtils;
    private final RentreeMapper rentreeMapper;

    public RentreeService(RentreeRepository rentreeRepository, ServiceUtils<Rentree> serviceUtils, RentreeMapper rentreeMapper) {
        this.rentreeRepository = rentreeRepository;
        this.serviceUtils = serviceUtils;
        this.rentreeMapper = rentreeMapper;
    }


    @Override
    public Rentree save(RentreeDto rentreeDto) {
        return rentreeRepository.save(rentreeMapper.dtoToRentree(rentreeDto));
    }

    @Override
    public Rentree update(Long id, Rentree rentree) {
        Optional<Rentree> optionalRentree = rentreeRepository.findById(id);
        Rentree rentreeToUpdate = optionalRentree.orElse(null);

        rentreeToUpdate = serviceUtils.copyProperties(rentreeToUpdate, rentree);

        assert rentreeToUpdate != null;
        rentreeToUpdate.setId(id);

        return rentreeRepository.save(rentreeToUpdate);
    }

    @Override
    public List<RentreeDto> allRentrees() {
        return rentreeRepository.findAll()
                .stream()
                .map(rentreeMapper::rentreeToDto)
                .collect(Collectors.toList());
    }

    @Override
    public RentreeDto getById(Long id) {
        return rentreeMapper.rentreeToDto(rentreeRepository.findById(id).orElse(null));
    }

    @Override
    public void delete(Rentree rentree) {
        rentreeRepository.delete(rentree);
    }
}
