package com.privalue.notice;

import com.privalue.notice.dto.news.NewsListRequest;
import com.privalue.notice.dto.news.NewsListResponse;

/**
 * description:
 * date: 2021/3/15 18:56   By HuTianYu
 */

public interface INewsService {
  NewsListResponse getNewsList(NewsListRequest request);
}
