package mre.spring.facture.services;

import lombok.AllArgsConstructor;
import mre.spring.facture.dto.mappers.RentreeMapper;
import mre.spring.facture.dto.modelsdto.RentreeDto;
import mre.spring.facture.models.Rentree;
import mre.spring.facture.repositories.RentreeRepository;
import mre.spring.facture.utils.ServiceUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RentreeService implements RentreeServiceInterface {

    private final RentreeRepository rentreeRepository;
    private final ServiceUtils<Rentree> serviceUtils;

    @Override
    public Rentree save(Rentree rentree) {
        return rentreeRepository.save(rentree);
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
    public List<Rentree> allRentrees() {
        return rentreeRepository.findAll();
    }

    @Override
    public Rentree getById(Long id) {
        return rentreeRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Rentree rentree) {
        rentreeRepository.delete(rentree);
    }
}
