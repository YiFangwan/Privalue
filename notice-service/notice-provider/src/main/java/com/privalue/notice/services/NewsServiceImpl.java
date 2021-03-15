package com.privalue.notice.services;

import com.privalue.notice.INewsService;
import com.privalue.notice.dal.persistence.NewsMapper;
import com.privalue.notice.dto.news.NewsListRequest;
import com.privalue.notice.dto.news.NewsListResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * description:
 * date: 2021/3/15 18:56   By HuTianYu
 */

@Slf4j
@Component
@Service
public class NewsServiceImpl implements INewsService {

  @Autowired
  NewsMapper newsMapper;

  @Override
  public NewsListResponse getNewsList(NewsListRequest request) {
    NewsListResponse response = new NewsListResponse();
    try {
      request.requestCheck();
      return null;
    }catch (Exception e){

    }
    return null;
  }
}


