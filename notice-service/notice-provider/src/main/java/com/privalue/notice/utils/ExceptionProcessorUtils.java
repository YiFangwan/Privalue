package com.privalue.notice.utils;

import com.privalue.commons.result.AbstractResponse;
import com.privalue.commons.tool.exception.ExceptionUtil;
import com.privalue.notice.constants.NoticeResultCode;

/**
 * description:
 * date: 2021/3/11 20:26   By HuTianYu
 */

public class ExceptionProcessorUtils {

  public static void wrapperHandlerException(AbstractResponse response,Exception e){

    try {
      ExceptionUtil.handlerException4biz(response,e);
    } catch (Exception ex) {
        response.setCode(NoticeResultCode.ERROR.getCode());
        response.setMsg(NoticeResultCode.ERROR.getMessage());
    }
  }
}


