package com.privalue.commons.result;

import java.io.Serializable;

/**
 * description:
 * date: 2021/2/25 16:27   By HuTianYu
 */

public abstract class AbstractRequest implements Serializable {

  private static final long serialVersionUID = -6249769847440652473L;
  public abstract void requestCheck();

  @Override
  public String toString() {
    return "AbstractRequest{}";
  }
}


