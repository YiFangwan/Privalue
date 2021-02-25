package com.privalue.commons.result;

/**
 * description:
 * date: 2021/2/25 16:34   By HuTianYu
 */

public class ResponseData<T> {

  private boolean success;

  private String message; //消息

  private int code;

  private T result;

  private long timestamp = System.currentTimeMillis(); //时间戳

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public T getResult() {
    return result;
  }

  public void setResult(T result) {
    this.result = result;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }
}


