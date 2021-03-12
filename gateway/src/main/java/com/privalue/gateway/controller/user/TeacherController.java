package com.privalue.gateway.controller.user;

import com.privalue.commons.result.ResponseData;
import com.privalue.commons.result.ResponseUtil;
import com.privalue.user.ITeacherService;
import com.privalue.user.constants.UserResultCode;
import com.privalue.user.dto.*;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user/teacher")
@Api(tags = "TeacherController",description = "教师控制层")
public class TeacherController {

  @Reference(timeout = 30000,check = false)
  ITeacherService teacherService;

  @GetMapping("/teacherInfo")
  public ResponseData getTeacherInfo(TeacherInfoRequest request){
    log.debug("Teacher_ID ; [" + request.getId() + "]");
    TeacherInfoResponse teacherInfoResponse = teacherService.getTeacherInfo(request);
    return new ResponseUtil<>().setData(teacherInfoResponse);
  }

  @GetMapping("/teacherList")
  public ResponseData getTeacherList(){
    log.debug("获取全部教师的信息");
    TeacherListResponse teacherList = teacherService.getTeacherList();
    return new ResponseUtil<>().setData(teacherList);
  }

  @PostMapping("register")
  public ResponseData register(@RequestBody TeacherRegisterRequest request){
    log.debug("Add teacher" + request.getTeacherName());
    TeacherRegisterResponse register = teacherService.register(request);
    if (register.getCode().equals(UserResultCode.SUCCESS.getCode())){
      return new ResponseUtil<>().setData("ok");
    }
    return new ResponseUtil<>().setErrorMsg("插入教师信息错误");
  }

  @GetMapping("delete")
  public ResponseData teacherDelete(TeacherDeleteRequest request){
    log.debug("delete teacher" + request);
    TeacherDeleteResponse teacherDeleteResponse = teacherService.delete(request.getId());
    if (teacherDeleteResponse.getCode().equals(UserResultCode.SUCCESS.getCode())){
      return new ResponseUtil<>().setData(teacherDeleteResponse);
    }
    return new ResponseUtil<>().setErrorMsg(teacherDeleteResponse.getMsg());
  }

}


