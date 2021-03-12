package com.privalue.commons.tool.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * description:
 * date: 2021/3/11 10:02   By HuTianYu
 */

public class UtilDate {

  /**
   * 年月日时分秒(无下划线) yyyyMMddHHmmss
   */
  public static final String dtLong = "yyyyMMddHHmmss";

  /**
   * 完整时间 yyyy-MM-dd HH:mm:ss
   */
  public static final String simple = "yyyy-MM-dd HH:mm:ss";

  /**
   * 年月日(无下划线) yyyyMMdd
   */
  public static final String dtShort = "yyyyMMdd";

  /**
   * 获取系统当前日期(精确到毫秒)，格式：yyyy-MM-dd HH:mm:ss
   *
   * @return
   */
  public static String getDateFormatter() {
    Date date = new Date();
    DateFormat df = new SimpleDateFormat(simple);
    return df.format(date);
  }

  /**
   * 获取系统当期年月日(精确到天)，格式：yyyyMMdd
   * @return
   */
  public static String getDate() {
    Date date = new Date();
    DateFormat df = new SimpleDateFormat(dtShort);
    return df.format(date);
  }

  public static String getExpireTime(Long time) {
    DateFormat df = new SimpleDateFormat(dtLong);
    Date afterTime = new Date(new Date().getTime() + time);
    return df.format(afterTime);
  }

  public static Date parseStrToDate(String strTime, String timeformat,
                                    Date defaultValue) {
    try {
      DateFormat dateFormat = new SimpleDateFormat(timeformat);
      return dateFormat.parse(strTime);
    } catch (Exception e) {
      return defaultValue;
    }
  }
}


