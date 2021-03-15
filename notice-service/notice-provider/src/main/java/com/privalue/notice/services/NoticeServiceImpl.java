package com.privalue.notice.services;

import com.github.pagehelper.PageHelper;
import com.privalue.commons.tool.exception.BizException;
import com.privalue.notice.INoticeService;
import com.privalue.notice.constants.NoticeResultCode;
import com.privalue.notice.constants.NoticeState;
import com.privalue.notice.converter.NoticeConverter;
import com.privalue.notice.dal.entitys.Notice;
import com.privalue.notice.dal.persistence.NoticeMapper;
import com.privalue.notice.dto.notice.*;
import com.privalue.notice.utils.ExceptionProcessorUtils;
import com.privalue.notice.utils.JudgeStateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * description:
 * date: 2021/3/11 17:31   By HuTianYu
 */

@Slf4j
@Component
@Service
public class NoticeServiceImpl implements INoticeService {

  @Autowired
  NoticeMapper noticeMapper;

  @Autowired
  NoticeConverter noticeConverter;

  @Override
  public NoticeListResponse getNoticeList(NoticeListRequest request){
    NoticeListResponse response = new NoticeListResponse();
    try {
      request.requestCheck();
      int count = noticeMapper.selectCount(NoticeState.DELETE.getState());
      PageHelper.startPage(request.getPage(),request.getSize());
      List<NoticeDto> noticeDtos = noticeMapper.selectAll(NoticeState.DELETE.getState());
      response.setCount(count);
      response.setCode(NoticeResultCode.SUCCESS.getCode());
      response.setNoticeDtos(noticeDtos);
    } catch (Exception e) {
      log.error(" 查询通知列表失败 " + e.getMessage());
      ExceptionProcessorUtils.wrapperHandlerException(response,e);
    }
    return response;
  }

  @Override
  public NoticePauseResponse pausePublish(NoticePauseRequest request) {
    NoticePauseResponse response = new NoticePauseResponse();
    try {
      request.requestCheck();
      int update = noticeMapper.updateStateByPrimaryKey(request.getNoticeId(),
          NoticeState.PAUSE.getState());
      if(update != 1){
        throw new BizException(NoticeResultCode.UPDATE_NOTICE_STATE_ERROR.getMessage());
      }
      response.setCode((NoticeResultCode.SUCCESS.getCode()));
      response.setMsg(NoticeResultCode.SUCCESS.getMessage());
    }catch (BizException e){
      log.error("暂停通知状态失败");
      ExceptionProcessorUtils.wrapperHandlerException(response,e);
      e.printStackTrace();
    }
    return response;
  }

  @Override
  public NoticeDeleteResponse deleteNotice(NoticeDeleteRequest request) {
    NoticeDeleteResponse response = new NoticeDeleteResponse();
    try {
      int delete = noticeMapper.updateStateByPrimaryKey(request.getNoticeId(),
          NoticeState.DELETE.getState());
      if (delete != 1){
        throw new BizException(NoticeResultCode.DELETE_NOTICE_STATE_ERROR.getMessage());
      }
      response.setCode(NoticeResultCode.SUCCESS.getCode());
      response.setMsg(NoticeResultCode.SUCCESS.getMessage());
    }catch (BizException e){
      log.error("删除通知失败");
      ExceptionProcessorUtils.wrapperHandlerException(response, e);
      e.printStackTrace();
    }
    return response;
  }

  @Override
  public NoticeCreateResponse createNotice(NoticeCreateRequest request) {
    NoticeCreateResponse response = new NoticeCreateResponse();
    try{
      request.requestCheck();
      Notice notice = noticeConverter.req2Notice(request);
      String state = JudgeStateUtils.judgeNoticeState(notice.getBeginDate(),notice.getEndDate());
      notice.setState(state);
      int insert = noticeMapper.insert(notice);
      if (insert != 1){
        throw new BizException(NoticeResultCode.CREATE_NOTICE_ERROR.getCode());
      }
      response.setCode(NoticeResultCode.SUCCESS.getCode());
      response.setMsg(NoticeResultCode.SUCCESS.getMessage());
    }catch (Exception e){
      log.error("创建通知异常" + e);
      ExceptionProcessorUtils.wrapperHandlerException(response,e);
      e.printStackTrace();
    }
    return response;
  }

  @Override
  public NoticeCreateResponse updateNotice(NoticeModifyRequest request) {
    NoticeCreateResponse response = new NoticeCreateResponse();
    try{
      Notice notice = noticeConverter.req2Notice(request);
      if (NoticeState.PAUSE.getState().equals(request.getState())){
        notice.setState(NoticeState.PAUSE.getState());
      }else {
        notice.setState(JudgeStateUtils.judgeNoticeState(request.getBeginDate(),
            request.getEndDate()));
      }
      int update = noticeMapper.updateByPrimaryKey(notice);
      if (update != 1){
        throw new BizException(NoticeResultCode.UPDATE_NOTICE_ERROR.getCode());
      }
      response.setCode(NoticeResultCode.SUCCESS.getCode());
      response.setMsg(NoticeResultCode.SUCCESS.getMessage());
    }catch (Exception e){
      log.error("更新通知异常" + e);
      ExceptionProcessorUtils.wrapperHandlerException(response,e);
      e.printStackTrace();
    }
    return response;
  }

  @Override
  public NoticeListResponse searchNotice(NoticeSearchRequest request) {
    NoticeListResponse response = new NoticeListResponse();
    try{
      if (request.getKeyword() == null){
        return getNoticeList(request);
      }
      int count = noticeMapper.selectCountByKeyword(request.getKeyword(),
          NoticeState.DELETE.getState());
      response.setCount(count);
      PageHelper.startPage(request.getPage(), request.getSize());
      List<NoticeDto> noticeDtos = noticeMapper.selectByKeyword(request.getKeyword(),
          NoticeState.DELETE.getState());
      response.setNoticeDtos(noticeDtos);
      response.setCode(NoticeResultCode.SUCCESS.getCode());
      response.setMsg(NoticeResultCode.SUCCESS.getMessage());
    }catch (Exception e){
      log.error("搜索通知异常" + e);
      ExceptionProcessorUtils.wrapperHandlerException(response,e);
      e.printStackTrace();
    }
    return response;
  }
}


