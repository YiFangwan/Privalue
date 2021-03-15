package com.privalue.notice.dto.news;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * description:
 * date: 2021/3/15 20:03   By HuTianYu
 */

@Data
public class NewsDto {
  private Integer noticeId;

  private String title;

  private String content;

  private String state;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "CST")
  private Date beginDate;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "CST")
  private Date endDate;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "CST")
  private Date updateDate;
}


