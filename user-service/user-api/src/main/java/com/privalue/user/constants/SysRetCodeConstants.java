package com.privalue.user.constants;

public enum SysRetCodeConstants {

  SUCCESS ("000000","成功");

  private String code;
  private String message;

  SysRetCodeConstants(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public static String getMessage(String code){
    for (SysRetCodeConstants value : SysRetCodeConstants.values()) {
      if (null == code) break;
      if (value.code.equals(code)){
        return value.message;
      }
    }
    return null;
  }
}
