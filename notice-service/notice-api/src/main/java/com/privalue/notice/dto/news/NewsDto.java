package com.privalue.notice.dto.news;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * description:
 * date: 2021/3/15 20:03   By HuTianYu
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsDto implements Serializable {

  private Integer newsId;

  private String title;

  private String content;

  private String brief;

  private String state;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "CST")
  private Date beginDate;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "CST")
  private Date endDate;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "CST")
  private Date updateDate;

  public void setContent(String content) {
    this.content = content;
    this.brief = content.replaceAll("<.*?>", "");
  }

}


