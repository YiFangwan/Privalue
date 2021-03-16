package com.privalue.gateway.controller.user;

import com.privalue.commons.result.ResponseData;
import com.privalue.commons.result.ResponseUtil;
import com.privalue.user.ITeacherService;
import com.privalue.user.constants.UserResultCode;
import com.privalue.user.dto.teacher.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

  @ApiOperation("获取教师信息")
  @GetMapping("/teacherInfo")
  public ResponseData getTeacherInfo(TeacherInfoRequest request){
    log.debug("Teacher_ID ; [" + request.getId() + "]");
    TeacherInfoResponse teacherInfoResponse = teacherService.getTeacherInfo(request);
    return new ResponseUtil<>().setData(teacherInfoResponse);
  }

  @ApiOperation("获取教师列表")
  @GetMapping("/teacherList")
  public ResponseData getTeacherList(){
    log.debug("获取全部教师的信息");
    TeacherListResponse teacherList = teacherService.getTeacherList();
    return new ResponseUtil<>().setData(teacherList);
  }

  @ApiOperation("新增教师")
  @PostMapping("/register")
  public ResponseData register(@RequestBody TeacherRegisterRequest request){
    log.debug("Add teacher" + request.getTeacherName());
    TeacherRegisterResponse register = teacherService.register(request);
    if (register.getCode().equals(UserResultCode.SUCCESS.getCode())){
      return new ResponseUtil<>().setData("ok");
    }
    return new ResponseUtil<>().setErrorMsg("插入教师信息错误");
  }

  @ApiOperation("删除教师")
  @DeleteMapping("/delete")
  public ResponseData teacherDelete(TeacherDeleteRequest request){
    log.debug("delete teacher" + request);
    TeacherDeleteResponse teacherDeleteResponse = teacherService.delete(request.getId());
    if (teacherDeleteResponse.getCode().equals(UserResultCode.SUCCESS.getCode())){
      return new ResponseUtil<>().setData(teacherDeleteResponse);
    }
    return new ResponseUtil<>().setErrorMsg(teacherDeleteResponse.getMsg());
  }

  @ApiOperation("修改教师")
  @PutMapping("/modify")
  public ResponseData teacherModify(@RequestBody TeacherModifyRequest request){
    TeacherModifyResponse response = teacherService.teacherModify(request);
    if (response.getCode().equals(UserResultCode.SUCCESS.getCode())){
      return new ResponseUtil<>().setData(response);
    }
    return new ResponseUtil<>().setErrorMsg(response.getMsg());
  }

  @ApiOperation("重置教师账号状态")
  @PutMapping("/restate")
  public ResponseData teacherRestate(TeacherRestateRequest request){
    TeacherRestateResponse response = teacherService.teacherRestate(request);
    if (response.getCode().equals(UserResultCode.SUCCESS.getCode())){
      return new ResponseUtil<>().setData(response);
    }
    return new ResponseUtil<>().setErrorMsg(response.getMsg());
  }

  @ApiOperation("重置教师账号密码")
  @PutMapping("resetPwd")
  public ResponseData teacherReset(TeacherResetRequest request){
    TeacherResetResponse response = teacherService.resetPwd(request);
    if (response.getCode().equals(UserResultCode.SUCCESS.getCode())){
      return new ResponseUtil<>().setData(response);
    }
    return new ResponseUtil<>().setErrorMsg(response.getMsg());
  }

}


