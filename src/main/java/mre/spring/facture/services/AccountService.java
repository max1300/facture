package mre.spring.facture.services;

import lombok.AllArgsConstructor;
import mre.spring.facture.exception.ObjectNotFoundException;
import mre.spring.facture.models.Account;
import mre.spring.facture.repositories.AccountRepository;
import mre.spring.facture.utils.ServiceUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AccountService implements AccountServiceInterface{

    private final AccountRepository accountRepository;
    private final ServiceUtils<Account> serviceUtils;

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(Long id, Account account) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        Account accountToUpdate = optionalAccount.orElseThrow(
                ()-> new ObjectNotFoundException("Account with id : " + id + " not found"));

        accountToUpdate = serviceUtils.copyProperties(accountToUpdate, account);

        assert accountToUpdate != null;
        accountToUpdate.setId(id);

        return accountRepository.save(accountToUpdate);
    }

    @Override
    public List<Account> allAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getById(Long id) {
        return accountRepository.findById(id).orElseThrow(
                ()-> new ObjectNotFoundException("Account with id : " + id + " not found"));
    }

    @Override
    public void delete(Account account) {
        accountRepository.delete(account);
    }

    @Override
    public Account findByCreatedAt(LocalDate date) {
        Account byCreatedAt = accountRepository.findByCreatedAt(date);
        return byCreatedAt;
    }

}
