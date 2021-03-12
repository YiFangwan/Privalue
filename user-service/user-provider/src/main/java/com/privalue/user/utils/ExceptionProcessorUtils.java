package com.privalue.user.utils;

import com.privalue.commons.result.AbstractResponse;
import com.privalue.commons.tool.exception.ExceptionUtil;
import com.privalue.user.constants.UserResultCode;

/**
 * description:
 * date: 2021/3/10 10:51   By HuTianYu
 */

public class ExceptionProcessorUtils {

  public static void wrapperHandlerException(AbstractResponse response,Exception e){
    try {
      ExceptionUtil.handlerException4biz(response,e);
    } catch (Exception ex) {
      response.setCode(UserResultCode.ERROR.getCode());
      response.setMsg(UserResultCode.ERROR.getMessage());
    }
  }
}


