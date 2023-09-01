package com.wangoo.supershop.infrastructure.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置JPA EntityManager的搜索范围
 * 避免各个工程由于Application文件在此包名的下级而导致基础包中的Entity搜索不到
 *
 * @author icyfenix@gmail.com
 * @date 2020/4/18 15:03
 **/
@Configuration
@EntityScan(basePackages = {"com.wangoo.supershop"})
public class JPAConfiguration {
}
