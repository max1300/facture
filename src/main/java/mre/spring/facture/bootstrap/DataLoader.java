package mre.spring.facture.bootstrap;

import lombok.AllArgsConstructor;
import mre.spring.facture.models.Category;
import mre.spring.facture.models.Depense;
import mre.spring.facture.models.Rentree;
import mre.spring.facture.repositories.CategoryRepository;
import mre.spring.facture.repositories.DepenseRepository;
import mre.spring.facture.repositories.RentreeRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final DepenseRepository depenseRepository;
    private final RentreeRepository rentreeRepository;
    private final CategoryRepository categoryRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        depenseRepository.saveAll(getDepenses());
        rentreeRepository.saveAll(getRentrees());
    }

    private Iterable<Rentree> getRentrees() {

        Category mutuelle = categoryRepository.findByNom("Mutuelle");

        List<Rentree> rentrees = new ArrayList<>();

        Rentree rentree = new Rentree();
        rentree.setAmount(1157.0);
        rentree.setDescription("salaire everwin");

        Rentree rentree2 = new Rentree();
        rentree2.setAmount(20.0);
        rentree2.setDescription("remboursement mutuelle");
        rentree2.setCategory(mutuelle);

        rentrees.add(rentree);
        rentrees.add(rentree2);
        return rentrees;
    }

    private Iterable<Depense> getDepenses() {

        Category maison = categoryRepository.findByNom("Maison");
        Category banque = categoryRepository.findByNom("Banque");


        List<Depense> depenses = new ArrayList<>();

        Depense depense = new Depense();
        depense.setAmount(100.0);
        depense.setDescription("achat lego harry potter pour noel");
        depense.setCategory(maison);

        Depense depense2 = new Depense();
        depense2.setAmount(40.0);
        depense2.setDescription("Agio");
        depense2.setCategory(banque);

        depenses.add(depense);
        depenses.add(depense2);
        return depenses;
    }
}
