package com.privalue.notice.dto.news;

import com.privalue.commons.result.AbstractRequest;
import com.privalue.commons.tool.exception.ValidateException;
import com.privalue.notice.constants.NoticeResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * description: 通知暂停发布
 * date: 2021/3/12 10:19   By HuTianYu
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class NewsPauseRequest extends AbstractRequest {

  private Integer newsId;

  @Override
  public void requestCheck() {

    if (newsId == null){
      throw new ValidateException(NoticeResultCode.REQUEST_CHECK_FAILURE.getCode(),
                                  NoticeResultCode.REQUEST_CHECK_FAILURE.getMessage());
    }

  }
}


