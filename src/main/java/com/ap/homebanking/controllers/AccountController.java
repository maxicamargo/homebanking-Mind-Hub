package com.ap.homebanking.controllers;

import com.ap.homebanking.dtos.AccountDTO;
import com.ap.homebanking.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping("/accounts")
    public  List<AccountDTO> getAccountDTO(){
        return accountRepository.findAll().stream().map(account -> new AccountDTO(account)).collect(toList());

    }

    @RequestMapping("/accounts/{id}")
    public AccountDTO accountDTO(@PathVariable Long id){
        AccountDTO accountDTO = new AccountDTO(accountRepository.findById(id).orElse(null));;
        return accountDTO;
    }

}
