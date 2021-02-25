package com.privalue.commons.result;

import java.io.Serializable;

/**
 * description:
 * date: 2021/2/25 16:33   By HuTianYu
 */

public abstract class AbstractResponse implements Serializable {

  private static final long serialVersionUID = 3284136280087335006L;
  private String code;
  private String msg;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}


