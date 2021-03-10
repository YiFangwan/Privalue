package com.privalue.commons.tool.exception;

import com.privalue.commons.result.AbstractResponse;

/**
 * description:
 * date: 2021/3/9 20:30   By HuTianYu
 */

public class ExceptionUtil {

  public static AbstractResponse handlerException4biz(AbstractResponse response,Exception e) throws Exception {
    Exception exception = null;
    if (!(e instanceof Exception)){
      return null;
    }
    if (e instanceof ValidateException){
      response.setCode(((ValidateException) e).getErrorCode());
      response.setMsg(e.getMessage());
    }else if (e instanceof ProcessException){
      response.setCode(((ProcessException)e).getErrorCode());
      response.setMsg(e.getMessage());
    }else if (e instanceof BizException){
      response.setCode(((BizException)e).getErrorCode());
      response.setMsg(e.getMessage());
    }else if (e instanceof Exception){
      throw e;
    }
    return response;
  }
}


