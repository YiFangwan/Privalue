package com.privalue.user.constants;

/*User-Service 统一错误码为01*/

public enum UserResultCode {
  //系统公用
  SUCCESS                   ("00000","成功"),
  ERROR                     ("10000","异常"),//不建议使用，应当使用更详细的错误码

  REQUEST_CHECK_FAILURE     ("01000","请求数据校验失败"),

  /*教师统一错误码为  021*/
  TEACHER_REGISTER_ERROR    ("02100","教师注册失败"),
  TEACHER_ACCOUNT_CREATE_ERR("02101","教师账号添加失败"),
  TEACHER_ACCOUNT_RESTATE_ERR("02102","重置教师账号状态失败"),
  TEACHER_PWD_RESET_ERR      ("02103","重置教师密码失败"),


  TEACHER_NO_EXIST          ("02199","教师不存在");







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
