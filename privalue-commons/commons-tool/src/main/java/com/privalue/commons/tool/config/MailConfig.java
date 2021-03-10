package com.privalue.commons.tool.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * description: 邮件配置类
 * date: 2021/3/8 19:52   By HuTianYu
 */

@Data
@Component
@ConfigurationProperties(prefix = "send.mail")
public class MailConfig {

  private String subject;
  private String sendFromMail;
  private String verifyUrl;
}


