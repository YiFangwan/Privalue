package com.privalue.gateway.controller.notice;

import com.privalue.commons.result.ResponseData;
import com.privalue.notice.INewsService;
import com.privalue.notice.dto.news.NewsListRequest;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 * date: 2021/3/15 17:58   By HuTianYu
 */

@Slf4j
@RestController
@RequestMapping("/news")
@Api(tags = "NewsController",description = "通知管理")
public class NewsController {

  @Reference(timeout = 3000,check = false)
  INewsService newsService;

  @GetMapping("/newsList")
  public ResponseData getNewsList(NewsListRequest request){
    newsService.getNewsList(request)

  }

}


