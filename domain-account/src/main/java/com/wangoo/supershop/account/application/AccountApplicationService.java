package com.wangoo.supershop.account.application;

import com.wangoo.supershop.account.domain.AccountRepository;
import com.wangoo.supershop.domain.account.Account;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@Transactional
public class AccountApplicationService {

    @Inject
    private AccountRepository repository;


    public Account findAccountByUsername(String username) {
        return repository.findByUsername(username);
    }
    public Iterable<Account> findAll() {
        return repository.findAll();
    }
}
