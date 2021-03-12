package com.privalue.notice.constants;

/**
 * description: 通知 状态
 * date: 2021/3/12 11:34   By HuTianYu
 */

public enum NoticeState {

  ACTIVE         ("A","发布中"),
  PAUSE          ("P","暂停发布"),
  WAIT           ("W","未开始"),
  EXPIRE         ("E","已到期"),
  DELETE         ("D","已删除");


  private String state;
  private String explain;

  NoticeState(String state, String explain) {
    this.state = state;
    this.explain = explain;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getExplain() {
    return explain;
  }

  public void setExplain(String explain) {
    this.explain = explain;
  }

  public String getExplain(String state){
    for (NoticeState value : NoticeState.values()) {
      if (null == state) break;
      if (value.state.equals(state)){
        return value.explain;
      }
    }
    return null;
  }

}
