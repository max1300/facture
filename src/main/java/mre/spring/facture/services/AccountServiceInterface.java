package mre.spring.facture.services;

import mre.spring.facture.models.Account;

import java.util.List;

public interface AccountServiceInterface {

    Account save(Account account);
    Account update(Long id, Account account);
    List<Account> allAccounts();
    Account getById(Long id);
    void delete(Account account);
}
