package com.privalue.notice.dto.news;

import com.privalue.commons.result.AbstractRequest;
import com.privalue.commons.tool.exception.ValidateException;
import com.privalue.notice.constants.NoticeResultCode;
import lombok.Data;

/**
 * description:
 * date: 2021/3/15 19:58   By HuTianYu
 */

@Data
public class NewsListRequest extends AbstractRequest {

  private Integer page;
  private Integer size;

  @Override
  public void requestCheck() {
    if (page == null || size == null){
      throw new ValidateException(NoticeResultCode.REQUEST_CHECK_FAILURE.getCode(),
          NoticeResultCode.REQUEST_CHECK_FAILURE.getMessage());
    }
  }
}


