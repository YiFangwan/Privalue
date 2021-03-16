package com.privalue.gateway.controller.notice;

import com.privalue.commons.result.ResponseData;
import com.privalue.commons.result.ResponseUtil;
import com.privalue.notice.INewsService;
import com.privalue.notice.constants.NoticeResultCode;
import com.privalue.notice.dto.news.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

/**
 * description:
 * date: 2021/3/15 17:58   By HuTianYu
 */

@Slf4j
@RestController
@RequestMapping("/news")
@Api(tags = "NewsController",description = "新闻管理")
public class NewsController {

  @Reference(timeout = 3000,check = false)
  INewsService newsService;

  @ApiOperation("获取新闻列表")
  @GetMapping("/newsList")
  public ResponseData getNewsList(NewsListRequest request){
    NewsListResponse response = newsService.getNewsList(request);
    if (response.getCode().equals(NoticeResultCode.SUCCESS.getCode())){
      return new ResponseUtil<>().setData(response);
    }
    return new ResponseUtil<>().setErrorMsg(response.getMsg());
  }

  @ApiOperation("暂停发布新闻")
  @PutMapping("/newsPause")
  public ResponseData newsPause(NewsPauseRequest request){
    NewsPauseResponse response = newsService.newsPause(request);
    if (response.getCode().equals(NoticeResultCode.SUCCESS.getCode())){
      return new ResponseUtil<>().setData(response);
    }
    return new ResponseUtil<>().setErrorMsg(response.getMsg());
  }

  @ApiOperation("删除新闻")
  @DeleteMapping("/newsDelete")
  @ApiImplicitParam(name = "newsId",value ="新闻ID",required = true)
  public ResponseData newsDelete(NewsDeleteRequest request){
    NewsDeleteResponse response = newsService.deleteNotice(request);
    if (response.getCode().equals(NoticeResultCode.SUCCESS.getCode())){
      return new ResponseUtil<>().setData(response);
    }
    return new ResponseUtil<>().setErrorMsg(response.getMsg());
  }

  @ApiOperation("创建新闻")
  @PostMapping("/newsCreate")
  public ResponseData newsCreate(@RequestBody NewsCreateRequest request){
    NewsCreateResponse response = newsService.createNotice(request);
    if (response.getCode().equals(NoticeResultCode.SUCCESS.getCode())){
      return new ResponseUtil<>().setData(response);
    }
    return new ResponseUtil<>().setErrorMsg(response.getMsg());
  }

  @ApiOperation("修改新闻")
  @PutMapping("/newsModify")
  public ResponseData newsModify(@RequestBody NewsModifyRequest request){
    NewsModifyResponse response = newsService.updateNotice(request);
    if (response.getCode().equals(NoticeResultCode.SUCCESS.getCode())){
      return new ResponseUtil<>().setData(response);
    }
    return new ResponseUtil<>().setErrorMsg(response.getMsg());
  }

  @ApiOperation("搜索新闻")
  @ApiImplicitParam(name = "keyword",value = "关键词",required = true)
  @GetMapping("/newsSearch")
  public ResponseData newsSearch(NewsSearchRequest request){
    NewsListResponse response = newsService.searchNotice(request);
    if (response.getCode().equals(NoticeResultCode.SUCCESS.getCode())){
      return new ResponseUtil<>().setData(response);
    }
    return new ResponseUtil<>().setErrorMsg(response.getMsg());
  }

}


