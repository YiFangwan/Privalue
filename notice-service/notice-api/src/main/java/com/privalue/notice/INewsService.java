package com.privalue.notice;

import com.privalue.notice.dto.news.*;

/**
 * description:
 * date: 2021/3/15 18:56   By HuTianYu
 */

public interface INewsService {
  NewsListResponse getNewsList(NewsListRequest request);

  NewsPauseResponse newsPause(NewsPauseRequest request);

  NewsDeleteResponse deleteNotice(NewsDeleteRequest request);

  NewsCreateResponse createNotice(NewsCreateRequest request);

  NewsModifyResponse updateNotice(NewsModifyRequest request);

  NewsListResponse searchNotice(NewsSearchRequest request);
}
