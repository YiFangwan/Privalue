package com.privalue.notice.dto.notice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description: 搜索通知
 * date: 2021/3/15 14:53   By HuTianYu
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeSearchRequest extends NoticeListRequest {

  private String keyword;

  @Override
  public void requestCheck() {

  }
}


