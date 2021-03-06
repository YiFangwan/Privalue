package com.privalue.commons.tool.exception;

/**
 * description:
 * date: 2021/3/9 17:28   By HuTianYu
 */

public class BaseBusinessException extends RuntimeException {

  protected String errorCode;

  protected String message;

  protected String extFields;

  public BaseBusinessException(){
    super();
  }

  public BaseBusinessException(String errorCode){
    super();
    this.errorCode = errorCode;
  }

  public BaseBusinessException(Throwable arg0){
    super(arg0);
  }

  public BaseBusinessException(String errorCode,Throwable cause){
    super(cause);
    this.errorCode = errorCode;
  }

  public BaseBusinessException(String errorCode,String message,Throwable cause){
    super(cause);
    this.errorCode = errorCode;
    this.message = message;
  }

  public BaseBusinessException(String errorCode,String message,String extFields, Throwable cause){
    super(cause);
    this.errorCode = errorCode;
    this.message = message;
    this.extFields = extFields;
  }

  public String getErrorCode(){
    return errorCode;
  }

  public void setErrorCode(String errorCode){
    this.errorCode = errorCode;
  }

  public String getExtFields(){
    return extFields;
  }

  public void setExtFields(String extFields){
    this.extFields = extFields;
  }

  public String getMessage(){
    return message;
  }

  public void setMessage(String message){
    this.message = message;
  }


}


