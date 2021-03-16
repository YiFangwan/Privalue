package com.privalue.notice.dto.news;

import com.privalue.notice.dto.notice.NoticeCreateRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description: 修改通知
 * date: 2021/3/15 12:07   By HuTianYu
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsModifyRequest extends NoticeCreateRequest {

  private Integer newsId;

  private String state;

}


