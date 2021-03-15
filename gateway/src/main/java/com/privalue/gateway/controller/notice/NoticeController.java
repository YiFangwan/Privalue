package com.privalue.gateway.controller.notice;

import com.privalue.commons.result.ResponseData;
import com.privalue.commons.result.ResponseUtil;
import com.privalue.notice.INoticeService;
import com.privalue.notice.constants.NoticeResultCode;
import com.privalue.notice.dto.notice.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

/**
 * description: 通知管理
 * date: 2021/3/11 13:38   By HuTianYu
 */

@Slf4j
@RestController
@RequestMapping("/notice")
@Api(tags = "NoticeController",description = "通知管理")
public class NoticeController {

  @Reference(timeout = 3000,check = false)
  INoticeService noticeService;

  @ApiOperation("获取通知列表")
  @GetMapping("/noticeList")
  public ResponseData getNoticeList(NoticeListRequest request){
    NoticeListResponse noticeList = noticeService.getNoticeList(request);
    if (noticeList.getCode().equals(NoticeResultCode.SUCCESS.getCode())){
      return new ResponseUtil<>().setData(noticeList);
    }
    return new ResponseUtil<>().setErrorMsg(noticeList.getMsg());
  }

  @ApiOperation("暂停发布通知")
  @PutMapping("/pausePublish")
  @ApiImplicitParam(name = "noticeId",value = "通知ID",required = true)
  public ResponseData pausePublish(NoticePauseRequest request){
    NoticePauseResponse response = noticeService.pausePublish(request);
    if (response.getCode().equals(NoticeResultCode.SUCCESS.getCode())){
      return new ResponseUtil<>().setData(response);
    }
    return new ResponseUtil<>().setErrorMsg(response.getMsg());
  }

  @ApiOperation("删除通知")
  @DeleteMapping("/deletePublish")
  @ApiImplicitParam(name = "noticeId",value = "通知ID",required = true)
  public ResponseData deletePublish(NoticeDeleteRequest request){
    NoticeDeleteResponse response = noticeService.deleteNotice(request);
    if (response.getCode().equals(NoticeResultCode.SUCCESS.getCode())){
      return new ResponseUtil<>().setData(response);
    }
    return new ResponseUtil<>().setErrorMsg(response.getMsg());
  }

  @ApiOperation("创建通知")
  @PostMapping("/create")
  public ResponseData noticeCreate(@RequestBody NoticeCreateRequest request){
    NoticeCreateResponse response = noticeService.createNotice(request);
    if (response.getCode().equals(NoticeResultCode.SUCCESS.getCode())){
      return new ResponseUtil<>().setData(response);
    }
    return new ResponseUtil<>().setErrorMsg(response.getMsg());
  }

  @ApiOperation("修改通知")
  @PutMapping("/noticeModify")
  public ResponseData noticeModify(@RequestBody NoticeModifyRequest request){
    NoticeCreateResponse response = noticeService.updateNotice(request);
    if (response.getCode().equals(NoticeResultCode.SUCCESS.getCode())){
      return new ResponseUtil<>().setData(response);
    }
    return new ResponseUtil<>().setErrorMsg(response.getMsg());
  }

  @ApiOperation("搜索通知")
  @ApiImplicitParam(name = "keyword",value = "关键词",required = true)
  @GetMapping("/noticeSearch")
  public ResponseData noticeSearch(NoticeSearchRequest request){
    NoticeListResponse response = noticeService.searchNotice(request);
    if (response.getCode().equals(NoticeResultCode.SUCCESS.getCode())){
      return new ResponseUtil<>().setData(response);
    }
    return new ResponseUtil<>().setErrorMsg(response.getMsg());
  }


}


