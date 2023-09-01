package com.wangoo.supershop.account.domain;

import com.wangoo.supershop.domain.account.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;


public interface AccountRepository extends CrudRepository<Account,Integer> {


    @Override
    Iterable<Account> findAll();

    Account findByUsername(String username);

}
