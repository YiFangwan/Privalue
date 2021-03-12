package com.privalue.notice.dto;

import com.privalue.commons.result.AbstractRequest;
import com.privalue.commons.tool.exception.ValidateException;
import com.privalue.notice.constants.NoticeResultCode;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * description:
 * date: 2021/3/12 15:54   By HuTianYu
 */

@Data
public class NoticeCreateRequest extends AbstractRequest {

  private String title;

  private String content;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date beginDate;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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


