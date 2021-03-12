package com.privalue.notice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * description:
 * date: 2021/3/11 17:26   By HuTianYu
 */

@Data
public class NoticeDto implements Serializable {

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


