package com.privalue.commons.tool.exception;

/**
 * description:
 * date: 2021/3/10 9:36   By HuTianYu
 */

public class ProcessException extends BaseBusinessException {

  public ProcessException(){
    super();
  }

  public ProcessException(String errorCode){
    super();
    this.errorCode = errorCode;
  }

  public ProcessException(Throwable arg0){
    super(arg0);
  }

  public ProcessException(String errorCode,Throwable cause){
    super(cause);
    this.errorCode = errorCode;
  }

  public ProcessException(String errorCode,String message){
    super();
    this.errorCode = errorCode;
    this.message = message;
  }

  public ProcessException(String errorCode,String message,Throwable cause){
    super(cause);
    this.errorCode = errorCode;
    this.message = message;
  }

}


