package com.privalue.notice.dto;

import com.privalue.commons.result.AbstractRequest;
import com.privalue.commons.tool.exception.ValidateException;
import com.privalue.notice.constants.NoticeResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:
 * date: 2021/3/11 14:03   By HuTianYu
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeListRequest extends AbstractRequest {

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


