package com.privalue.notice.dto.news;

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
public class NewsSearchRequest extends NewsListRequest {

  private String keyword;

  @Override
  public void requestCheck() {

  }
}


