package com.privalue.notice.utils;

import com.privalue.notice.constants.NoticeState;

import java.util.Date;

/**
 * description: 判断新闻 通知的生效状态
 * date: 2021/3/15 14:10   By HuTianYu
 */


public class JudgeStateUtils {

  public static String judgeNoticeState(Date beginDate,Date endDate){
    Date date = new Date();
    if (date.before(beginDate)){
      return NoticeState.WAIT.getState();
    }else if (date.after(endDate)){
      return NoticeState.EXPIRE.getState();
    }else {
      return NoticeState.ACTIVE.getState();
    }
  }
}


