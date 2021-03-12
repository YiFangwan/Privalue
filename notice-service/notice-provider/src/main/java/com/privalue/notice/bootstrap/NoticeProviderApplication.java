package com.privalue.notice.bootstrap;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * description:
 * date: 2021/3/11 13:51   By HuTianYu
 */

@EnableDubbo
@SpringBootApplication
@ComponentScan(basePackages = {"com.privalue.notice","com.privalue.commons"})
@MapperScan("com.privalue.notice.dal")
public class NoticeProviderApplication {

  public static void main(String[] args) {
    SpringApplication.run(NoticeProviderApplication.class,args);
  }
}


