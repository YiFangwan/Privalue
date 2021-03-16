package com.privalue.notice.dto.news;

import com.privalue.commons.result.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * description:
 * date: 2021/3/15 20:03   By HuTianYu
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsListResponse extends AbstractResponse {

  private Integer count;

  private List<NewsDto> newsDtos;
}


