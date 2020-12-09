package mre.spring.facture.bootstrap;

import lombok.AllArgsConstructor;
import mre.spring.facture.models.Account;
import mre.spring.facture.models.Category;
import mre.spring.facture.models.Depense;
import mre.spring.facture.models.Rentree;
import mre.spring.facture.repositories.AccountRepository;
import mre.spring.facture.repositories.CategoryRepository;
import mre.spring.facture.repositories.DepenseRepository;
import mre.spring.facture.repositories.RentreeRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final DepenseRepository depenseRepository;
    private final RentreeRepository rentreeRepository;
    private final CategoryRepository categoryRepository;
    private final AccountRepository accountRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        accountRepository.saveAll(getAccount());
        depenseRepository.saveAll(getDepenses());
        rentreeRepository.saveAll(getRentrees());
    }

    private List<Account> getAccount() {
        List<Account> accounts = new ArrayList<>();
        Account account = new Account();
        account.setNom("Compte 1");
        account.setCreatedAt(LocalDate.now());

        accounts.add(account);
        return accounts;
    }

    private List<Rentree> getRentrees() {
        Category mutuelle = categoryRepository.findByNom("Mutuelle");
        Account account =  accountRepository.findByCreatedAt(LocalDate.now());

        List<Rentree> rentrees = new ArrayList<>();

        Rentree rentree = new Rentree();
        rentree.setAmount(1157.0);
        rentree.setDescription("salaire everwin");
        account.addRentree(rentree);

        Rentree rentree2 = new Rentree();
        rentree2.setAmount(20.0);
        rentree2.setDescription("remboursement mutuelle");
        rentree2.setCategory(mutuelle);
        account.addRentree(rentree2);

        rentrees.add(rentree);
        rentrees.add(rentree2);
        return rentrees;
    }

    private List<Depense> getDepenses() {
        List<Depense> depenses = new ArrayList<>();
        Category maison = categoryRepository.findByNom("Maison");
        Category banque = categoryRepository.findByNom("Banque");
        Account account =  accountRepository.findByCreatedAt(LocalDate.now());

        Depense depense = new Depense();
        depense.setAmount(100.0);
        depense.setDescription("achat lego harry potter pour noel");
        depense.setCategory(maison);
        depense.setAccount(account);

        Depense depense2 = new Depense();
        depense2.setAmount(40.0);
        depense2.setDescription("Agio pour la banque");
        depense2.setCategory(banque);
        account.addDepense(depense2);
        account.addDepense(depense);

        depenses.add(depense);
        depenses.add(depense2);
        return depenses;
    }
}
