package mre.spring.facture.api;

import lombok.AllArgsConstructor;
import mre.spring.facture.dto.mappers.AccountMapper;
import mre.spring.facture.dto.modelsdto.AccountDto;
import mre.spring.facture.models.Account;
import mre.spring.facture.services.AccountServiceInterface;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/accounts")
public class AccountResource {

    private final AccountServiceInterface service;
    private final AccountMapper accountMapper;

    @GetMapping
    public List<AccountDto> allAccounts() {
        return service.allAccounts().stream()
                .map(account -> accountMapper.accountToDto(account))
                .collect(Collectors.toList());
    }

    @GetMapping("/{accountId}")
    public AccountDto getOne(@PathVariable("accountId") Long id) {
        return accountMapper.accountToDto(service.getById(id));
    }

    @PostMapping
    @Transactional(Transactional.TxType.REQUIRED)
    public Account create(@Valid @RequestBody AccountDto accountDto) {
        return service.save(accountMapper.dtoToAccount(accountDto));
    }

    @PostMapping("/{accountId}")
    @Transactional(Transactional.TxType.REQUIRED)
    public Account update(@PathVariable("accountId") Long id, @Valid @RequestBody Account account) {
        return service.update(id, account);
    }
}
