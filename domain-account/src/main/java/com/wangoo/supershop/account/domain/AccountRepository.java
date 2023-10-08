package com.wangoo.supershop.account.domain;

import com.wangoo.supershop.domain.account.Account;
import org.springframework.data.repository.CrudRepository;


public interface AccountRepository extends CrudRepository<Account,Integer> {


    @Override
    Iterable<Account> findAll();

    Account findByUsername(String username);


}
