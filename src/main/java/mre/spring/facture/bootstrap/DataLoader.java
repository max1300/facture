package mre.spring.facture.bootstrap;

import mre.spring.facture.models.Depense;
import mre.spring.facture.models.Rentree;
import mre.spring.facture.repositories.DepenseRepository;
import mre.spring.facture.repositories.RentreeRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final DepenseRepository depenseRepository;
    private final RentreeRepository rentreeRepository;

    public DataLoader(DepenseRepository depenseRepository, RentreeRepository rentreeRepository) {
        this.depenseRepository = depenseRepository;
        this.rentreeRepository = rentreeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        depenseRepository.saveAll(getDepenses());
        rentreeRepository.saveAll(getRentrees());
    }

    private Iterable<Rentree> getRentrees() {
        List<Rentree> rentrees = new ArrayList<>();

        Rentree rentree = new Rentree();
        rentree.setAmount(1157.0);
        rentree.setDescription("salaire everwin");

        Rentree rentree2 = new Rentree();
        rentree2.setAmount(20.0);
        rentree2.setDescription("remboursement mutuelle");

        rentrees.add(rentree);
        rentrees.add(rentree2);
        return rentrees;
    }

    private Iterable<Depense> getDepenses() {

        List<Depense> depenses = new ArrayList<>();

        Depense depense = new Depense();
        depense.setAmount(100.0);
        depense.setDescription("achat lego harry potter pour noel");

        Depense depense2 = new Depense();
        depense2.setAmount(40.0);
        depense2.setDescription("achat la clef - livre jeu pour noel");

        depenses.add(depense);
        depenses.add(depense2);
        return depenses;
    }
}
