package com.privalue.notice.services;

import com.github.pagehelper.PageHelper;
import com.privalue.commons.tool.exception.BizException;
import com.privalue.notice.INewsService;
import com.privalue.notice.constants.NoticeResultCode;
import com.privalue.notice.constants.NoticeState;
import com.privalue.notice.converter.NoticeConverter;
import com.privalue.notice.dal.entitys.News;
import com.privalue.notice.dal.persistence.NewsMapper;
import com.privalue.notice.dto.news.*;
import com.privalue.notice.utils.ExceptionProcessorUtils;
import com.privalue.notice.utils.JudgeStateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

  @Autowired
  NoticeConverter noticeConverter;

  @Override
  public NewsListResponse getNewsList(NewsListRequest request) {
    NewsListResponse response = new NewsListResponse();
    try {
      request.requestCheck();
      int count = newsMapper.selectCount(NoticeState.DELETE.getState());
      response.setCount(count);
      PageHelper.startPage(request.getPage(),request.getSize());
      List<NewsDto> newsDtos = newsMapper.selectAll(NoticeState.DELETE.getState());
      response.setNewsDtos(newsDtos);
      response.setCode(NoticeResultCode.SUCCESS.getCode());
    }catch (Exception e){
      log.error("查询新闻列表失败" + e.getMessage());
      ExceptionProcessorUtils.wrapperHandlerException(response,e);
    }
    return response;
  }

  @Override
  public NewsPauseResponse newsPause(NewsPauseRequest request) {
    NewsPauseResponse response = new NewsPauseResponse();
    try {
      request.requestCheck();
      int update = newsMapper.updateStateByPrimaryKey(request.getNewsId(),
          NoticeState.PAUSE.getState());
      if(update != 1){
        throw new BizException(NoticeResultCode.UPDATE_NEWS_STATE_ERROR.getMessage());
      }
      response.setCode((NoticeResultCode.SUCCESS.getCode()));
      response.setMsg(NoticeResultCode.SUCCESS.getMessage());
    }catch (BizException e){
      log.error("暂停新闻状态失败");
      ExceptionProcessorUtils.wrapperHandlerException(response,e);
      e.printStackTrace();
    }
    return response;
  }

  @Override
  public NewsDeleteResponse deleteNotice(NewsDeleteRequest request) {
    NewsDeleteResponse response = new NewsDeleteResponse();
    try {
      int delete = newsMapper.updateStateByPrimaryKey(request.getNewsId(),
          NoticeState.DELETE.getState());
      if (delete != 1){
        throw new BizException(NoticeResultCode.DELETE_NEWS_STATE_ERROR.getMessage());
      }
      response.setCode(NoticeResultCode.SUCCESS.getCode());
      response.setMsg(NoticeResultCode.SUCCESS.getMessage());
    }catch (BizException e){
      log.error("删除新闻失败");
      ExceptionProcessorUtils.wrapperHandlerException(response, e);
      e.printStackTrace();
    }
    return response;
  }

  @Override
  public NewsCreateResponse createNotice(NewsCreateRequest request) {
    NewsCreateResponse response = new NewsCreateResponse();
    try{
      request.requestCheck();
      News news = noticeConverter.req2News(request);
      String state = JudgeStateUtils.judgeNoticeState(news.getBeginDate(),news.getEndDate());
      news.setState(state);
      int insert = newsMapper.insert(news);
      if (insert != 1){
        throw new BizException(NoticeResultCode.CREATE_NEWS_ERROR.getCode());
      }
      response.setCode(NoticeResultCode.SUCCESS.getCode());
      response.setMsg(NoticeResultCode.SUCCESS.getMessage());
    }catch (Exception e){
      log.error("创建新闻异常" + e);
      ExceptionProcessorUtils.wrapperHandlerException(response,e);
      e.printStackTrace();
    }
    return response;
  }

  @Override
  public NewsModifyResponse updateNotice(NewsModifyRequest request) {
    NewsModifyResponse response = new NewsModifyResponse();
    try{
      News news = noticeConverter.req2News(request);
      if (NoticeState.PAUSE.getState().equals(request.getState())){
        news.setState(NoticeState.PAUSE.getState());
      }else {
        news.setState(JudgeStateUtils.judgeNoticeState(request.getBeginDate(),
            request.getEndDate()));
      }
      int update = newsMapper.updateByPrimaryKey(news);
      if (update != 1){
        throw new BizException(NoticeResultCode.UPDATE_NEWS_ERROR.getCode());
      }
      response.setCode(NoticeResultCode.SUCCESS.getCode());
      response.setMsg(NoticeResultCode.SUCCESS.getMessage());
    }catch (Exception e){
      log.error("更新新闻异常" + e);
      ExceptionProcessorUtils.wrapperHandlerException(response,e);
      e.printStackTrace();
    }
    return response;
  }

  @Override
  public NewsListResponse searchNotice(NewsSearchRequest request) {
    NewsListResponse response = new NewsListResponse();
    try{
      if (request.getKeyword() == null){
        return getNewsList(request);
      }
      int count = newsMapper.selectCountByKeyword(request.getKeyword(),
          NoticeState.DELETE.getState());
      response.setCount(count);
      PageHelper.startPage(request.getPage(), request.getSize());
      List<NewsDto> newsDtos = newsMapper.selectByKeyword(request.getKeyword(),
          NoticeState.DELETE.getState());
      response.setNewsDtos(newsDtos);
      response.setCode(NoticeResultCode.SUCCESS.getCode());
      response.setMsg(NoticeResultCode.SUCCESS.getMessage());
    }catch (Exception e){
      log.error("搜索新闻异常" + e);
      ExceptionProcessorUtils.wrapperHandlerException(response,e);
      e.printStackTrace();
    }
    return response;
  }
}


