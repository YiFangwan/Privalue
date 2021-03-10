package com.privalue.user.bootstrap;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * description:
 * date: 2021/2/26 14:50   By HuTianYu
 */

@EnableDubbo
@SpringBootApplication
@ComponentScan(basePackages = {"com.privalue.user","com.privalue.commons"})
@MapperScan("com.privalue.user.dal")
public class UserProviderApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserProviderApplication.class,args);
  }
}


