package com.privalue.notice.constants;

/**
 * description:
 * date: 2021/3/11 20:12   By HuTianYu
 */

public enum NoticeResultCode {

  //系统公用
  SUCCESS                         ("00000","成功"),
  ERROR                           ("10000","异常"),

  REQUEST_CHECK_FAILURE           ("01000","请求数据校验失败"),

  UPDATE_NOTICE_STATE_ERROR       ("02001","更新通知状态异常"),
  DELETE_NOTICE_STATE_ERROR       ("02002","删除通知消息异常"),
  PARAM_TIME_ERROR                ("02003","输入时间不合法"),
  NOTICE_CONTENT_ERROR            ("02004","通知内容不能为空"),
  CREATE_NOTICE_ERROR             ("02005","创建通知失败");

  private String code;
  private String message;

  NoticeResultCode(String code, String message) {
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
    for (NoticeResultCode value : NoticeResultCode.values()) {
      if (null == code) break;
      if (value.code.equals(code)){
        return value.message;
      }
    }
    return null;
  }
}
