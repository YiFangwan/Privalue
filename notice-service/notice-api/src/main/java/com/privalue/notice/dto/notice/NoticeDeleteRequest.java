package com.privalue.notice.dto.notice;

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
public class NoticeDeleteRequest extends AbstractRequest {

  private Integer noticeId;

  @Override
  public void requestCheck() {
    if (noticeId == null){
      throw new ValidateException(NoticeResultCode.REQUEST_CHECK_FAILURE.getCode(),
                                  NoticeResultCode.REQUEST_CHECK_FAILURE.getMessage());
    }
  }
}


