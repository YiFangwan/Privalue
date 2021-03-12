package com.privalue.notice.dto;

import com.privalue.commons.result.AbstractRequest;
import com.privalue.commons.tool.exception.ValidateException;
import com.privalue.notice.constants.NoticeResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description: 通知暂停发布
 * date: 2021/3/12 10:19   By HuTianYu
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticePauseRequest extends AbstractRequest {

  private Integer noticeId;

  @Override
  public void requestCheck() {

    if (noticeId == null){
      throw new ValidateException(NoticeResultCode.REQUEST_CHECK_FAILURE.getCode(),
                                  NoticeResultCode.REQUEST_CHECK_FAILURE.getMessage());
    }

  }
}


