package com.privalue.notice.dto.news;

import com.privalue.commons.result.AbstractRequest;
import com.privalue.commons.tool.exception.ValidateException;
import com.privalue.notice.constants.NoticeResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:
 * date: 2021/3/12 11:27   By HuTianYu
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsDeleteRequest extends AbstractRequest {

  private Integer newsId;

  @Override
  public void requestCheck() {
    if (newsId == null){
      throw new ValidateException(NoticeResultCode.REQUEST_CHECK_FAILURE.getCode(),
                                  NoticeResultCode.REQUEST_CHECK_FAILURE.getMessage());
    }
  }
}


