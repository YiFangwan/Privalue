package com.privalue.user.constants;

/*User-Service 统一错误码为01*/

public enum UserResultCode {
  //系统公用
  SUCCESS                   ("00000","成功"),
  ERROR                     ("10000","异常"),//不建议使用，应当使用更详细的错误码

  /*教师统一错误码为  011*/
  TEACHER_REGISTER_ERROR    ("01100","教师注册失败"),
  TEACHER_NO_EXIST          ("01199","教师不存在");







  private String code;
  private String message;

  UserResultCode(String code, String message) {
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
    for (UserResultCode value : UserResultCode.values()) {
      if (null == code) break;
      if (value.code.equals(code)){
        return value.message;
      }
    }
    return null;
  }
}