package com.privalue.notice.dto.notice;

import com.privalue.commons.result.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * description:
 * date: 2021/3/11 17:16   By HuTianYu
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeListResponse extends AbstractResponse {

  private Integer count;

  private List<NoticeDto> noticeDtos;

}


