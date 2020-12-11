package mre.spring.facture.api;

import lombok.AllArgsConstructor;
import mre.spring.facture.dto.mappers.AccountMapper;
import mre.spring.facture.dto.modelsdto.AccountDto;
import mre.spring.facture.models.Account;
import mre.spring.facture.services.AccountServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/accounts")
public class AccountResource {

    private final AccountServiceInterface service;
    private final AccountMapper accountMapper;

    @GetMapping
    public ResponseEntity<AccountDto> allAccounts() {
        List<AccountDto> collect = service.allAccounts().stream()
                .map(accountMapper::accountToDto)
                .collect(Collectors.toList());
        return new ResponseEntity(collect, HttpStatus.OK);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDto> getOne(@PathVariable("accountId") Long id) {
        AccountDto accountDto = accountMapper.accountToDto(service.getById(id));
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

    @PostMapping
    @Transactional(Transactional.TxType.REQUIRED)
    public ResponseEntity<Account> create(@Valid @RequestBody AccountDto accountDto) {
        Account save = service.save(accountMapper.dtoToAccount(accountDto));
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @PostMapping("/{accountId}")
    @Transactional(Transactional.TxType.REQUIRED)
    public ResponseEntity<Account> update(@PathVariable("accountId") Long id, @Valid @RequestBody Account account) {
        Account update = service.update(id, account);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }
}
