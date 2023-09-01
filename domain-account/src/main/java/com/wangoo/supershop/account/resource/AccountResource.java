package com.wangoo.supershop.account.resource;

import com.wangoo.supershop.account.application.AccountApplicationService;
import com.wangoo.supershop.domain.account.Account;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountResource {


    @Inject
    private AccountApplicationService service;

    /**
     * 根据用户名称获取用户详情
     */
    @GET
    @Path("/{username}")
    public Account getUser(@PathParam("username") String username) {
        return service.findAccountByUsername(username);
    }

}
