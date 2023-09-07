package com.wangoo.supershop.account.domain;

import com.wangoo.supershop.domain.account.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


public interface AccountRepository extends CrudRepository<Account,Integer> {


    @Override
    Iterable<Account> findAll();

    Account findByUsername(String username);

}
