package com.wangoo.supershop.account.resource;

import com.wangoo.supershop.account.application.AccountApplicationService;
import com.wangoo.supershop.domain.account.Account;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@CacheConfig(cacheNames = "resource.account")
public class AccountResource {


    @Inject
    private AccountApplicationService service;

    /**
     * 根据用户名称获取用户详情
     */
    @GetMapping(path = "/{username}")
    @ResponseBody
    @Cacheable(key = "#username")
    @PreAuthorize("hasAuthority('SCOPE_SERVICE')")
    public Account getUser(@PathVariable("username") String username) {
        return service.findAccountByUsername(username);
    }


    @GetMapping
    @ResponseBody
    @PreAuthorize("hasAuthority('SCOPE_SERVICE')")
    public Iterable<Account> findAll() {
        Iterable<Account> result = service.findAll();
        System.out.println(result.toString());
        return result;
    }
}
