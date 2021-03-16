package com.privalue.notice.dto.news;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.privalue.commons.result.AbstractRequest;
import com.privalue.commons.tool.exception.ValidateException;
import com.privalue.notice.constants.NoticeResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * description:
 * date: 2021/3/16 9:22   By HuTianYu
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsCreateRequest extends AbstractRequest {
  private String title;

  private String content;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date beginDate;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date endDate;

  private Integer creator;


  @Override
  public void requestCheck() {
    if (beginDate == null || endDate == null){
      throw new ValidateException(NoticeResultCode.PARAM_TIME_ERROR.getCode(),
          NoticeResultCode.PARAM_TIME_ERROR.getMessage());
    }
    if (StringUtils.isBlank(title) || StringUtils.isBlank(content)){
      throw new ValidateException(NoticeResultCode.NOTICE_CONTENT_ERROR.getCode(),
          NoticeResultCode.NOTICE_CONTENT_ERROR.getMessage());
    }
  }
}


