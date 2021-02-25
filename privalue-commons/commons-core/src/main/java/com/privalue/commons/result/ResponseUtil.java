package com.privalue.commons.result;

/**
 * description:
 * date: 2021/2/25 16:38   By HuTianYu
 */

public class ResponseUtil<T> {

  private ResponseData<T> responseData;

  public ResponseUtil() {
    responseData = new ResponseData<>();
    responseData.setSuccess(true);
    responseData.setMessage("success");
    responseData.setCode(200);
  }

  public ResponseData<T> setData(T t){
    this.responseData.setResult(t);
    this.responseData.setSuccess(true);
    this.responseData.setCode(200);
    return this.responseData;
  }

  public ResponseData<T> setData(T t,String message){
    this.responseData.setResult(t);
    this.responseData.setSuccess(true);
    this.responseData.setMessage(message);
    this.responseData.setCode(200);
    return this.responseData;
  }

  public ResponseData<T> setErrorMsg(String message){
    this.responseData.setSuccess(false);
    this.responseData.setMessage(message);
    this.responseData.setCode(500);
    return this.responseData;
  }

  public ResponseData<T> setErrorMsg(Integer code,String message){
    this.responseData.setSuccess(false);
    this.responseData.setCode(code);
    this.responseData.setMessage(message);
    return this.responseData;
  }
}


