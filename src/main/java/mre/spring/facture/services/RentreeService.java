package mre.spring.facture.services;

import mre.spring.facture.models.Rentree;
import mre.spring.facture.repositories.RentreeRepository;
import mre.spring.facture.utils.ServiceUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentreeService implements RentreeServiceInterface {

    private final RentreeRepository rentreeRepository;
    private final ServiceUtils<Rentree> serviceUtils;

    public RentreeService(RentreeRepository rentreeRepository, ServiceUtils<Rentree> serviceUtils) {
        this.rentreeRepository = rentreeRepository;
        this.serviceUtils = serviceUtils;
    }


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
    public Iterable<Rentree> allRentrees() {
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
