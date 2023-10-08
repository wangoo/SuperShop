package com.wangoo.supershop.account.resource;

import com.wangoo.supershop.account.application.AccountApplicationService;
import com.wangoo.supershop.domain.account.Account;
import jakarta.inject.Inject;
import org.redisson.api.RedissonClient;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@CacheConfig(cacheNames = "resource.account")
public class AccountResource {


    @Inject
    private AccountApplicationService service;

    @Inject
    private RedissonClient redissonClient;

    @Inject
    private RedisTemplate redisTemplate;

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

    @GetMapping(path = "/redisTemplate/{username}")
    @ResponseBody
    @PreAuthorize("hasAuthority('SCOPE_SERVICE')")
    public Account getUserredisTemplate(@PathVariable("username") String username) {

        return  (Account) redisTemplate.opsForValue().get(username);
    }

    @GetMapping(path = "/redisson/{username}")
    @ResponseBody
    @PreAuthorize("hasAuthority('SCOPE_SERVICE')")
    public Account getUserRedisson(@PathVariable("username") String username) {
        return (Account)redissonClient.getMap(username);
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
