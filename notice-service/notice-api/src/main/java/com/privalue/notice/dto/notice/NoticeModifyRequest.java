package com.privalue.notice.dto.notice;

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
public class NoticeModifyRequest extends NoticeCreateRequest {

  private Integer noticeId;

  private String state;

}


