package com.privalue.user.services;

import com.privalue.commons.tool.exception.BizException;
import com.privalue.user.ITeacherService;
import com.privalue.user.constants.UserResultCode;
import com.privalue.user.converter.TeacherConverter;
import com.privalue.user.dal.entitys.Teacher;
import com.privalue.user.dal.entitys.TeacherAccount;
import com.privalue.user.dal.persistence.TeacherAccountMapper;
import com.privalue.user.dal.persistence.TeacherMapper;
import com.privalue.user.dto.teacher.*;
import com.privalue.user.utils.ExceptionProcessorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;


/**
 * description:
 * date: 2021/3/2 20:03   By HuTianYu
 */

@Slf4j
@Component
@Service
public class TeacherServiceImpl implements ITeacherService {

  @Autowired
  TeacherMapper teacherMapper;

  @Autowired
  TeacherAccountMapper teacherAccountMapper;

  @Autowired
  TeacherConverter teacherConverter;

  @Override
  public TeacherInfoResponse getTeacherInfo(TeacherInfoRequest request) {
    Teacher teacher = teacherMapper.selectByPrimaryKey(request.getId());
    TeacherInfoResponse teacherInfoResponse = teacherConverter.teacher2Res(teacher);
    return teacherInfoResponse;
  }

  /**
   * 注册写入 Teacher 表 和 TeacherAccount表
   * @param request
   * @return
   */
  @Override
  public TeacherRegisterResponse register(TeacherRegisterRequest request) {

    TeacherRegisterResponse response = new TeacherRegisterResponse();
    try {
      request.requestCheck();
      Teacher teacher = teacherConverter.req2Teacher(request);
      int insertTeacher = teacherMapper.insert(teacher);
      if (insertTeacher != 1){
        throw new BizException(UserResultCode.TEACHER_REGISTER_ERROR.getMessage());
      }
      TeacherAccount teacherAccount = new TeacherAccount();
      teacherAccount.setTeacherId(teacher.getId());
      teacherAccount.setAccount(teacher.getTeacherCode() + "@" + teacher.getSchool());
      teacherAccount.setPassword("111111");
      teacherAccount.setAccState("N");
      teacherAccount.setCreateDate(new Date());
      teacherAccount.setUpdateDate(new Date());
      teacherAccount.setDeleteFlag(false);
      int insertAccount = teacherAccountMapper.insert(teacherAccount);
      if (insertAccount != 1){
        throw new BizException(UserResultCode.TEACHER_ACCOUNT_CREATE_ERR.getMessage());
      }
      response.setCode(UserResultCode.SUCCESS.getCode());
      response.setMsg(UserResultCode.SUCCESS.getMessage());
    } catch (BizException e) {
      log.error("教师注册失败" + e.getMessage());
      ExceptionProcessorUtils.wrapperHandlerException(response,e);
      e.printStackTrace();
    }
    return response;
  }

  @Override
  public TeacherDeleteResponse delete(Integer id) {
    TeacherDeleteResponse teacherDeleteResponse = new TeacherDeleteResponse();
    int deleteByPrimaryKey = teacherMapper.deleteByPrimaryKey(id);
    if (deleteByPrimaryKey == 1){
      teacherDeleteResponse.setCode(UserResultCode.SUCCESS.getCode());
      teacherDeleteResponse.setMsg(UserResultCode.SUCCESS.getMessage());
    }else {
      teacherDeleteResponse.setCode(UserResultCode.TEACHER_NO_EXIST.getCode());
      teacherDeleteResponse.setMsg(UserResultCode.TEACHER_NO_EXIST.getMessage());
    }
    return teacherDeleteResponse;
  }

  @Override
  public TeacherListResponse getTeacherList() {
    Example example = new Example(Teacher.class);
    example.selectProperties("id","teacherCode","teacherName","phoneNumber","gender",
        "age","nation","updateDate","email","department","position")
        .createCriteria().andEqualTo("deleteFlag",0);
    List<Teacher> teachers = teacherMapper.selectByExample(example);
    List<TeacherListDto> teacherListDtos = new LinkedList<>();
    for (Teacher teacher : teachers) {
      TeacherListDto teacherListDto = teacherConverter.teacher2List(teacher);
      teacherListDtos.add(teacherListDto);
    }
//    List<TeacherListDto> teacherListDtos = teacherConverter.teacher2List(teachers);
    TeacherListResponse teacherListResponse = new TeacherListResponse();
    teacherListResponse.setTeacherListDtos(teacherListDtos);
    return teacherListResponse;
  }

  @Override
  public TeacherModifyResponse teacherModify(TeacherModifyRequest request) {
    TeacherModifyResponse response = new TeacherModifyResponse();
    try {
      Teacher teacher = teacherConverter.req2Teacher(request);
      int update = teacherMapper.updateByPrimaryKey(teacher);
      if (update != 1){
        throw new BizException(UserResultCode.ERROR.getMessage());
      }
      response.setCode(UserResultCode.SUCCESS.getCode());
      response.setMsg(UserResultCode.SUCCESS.getMessage());
    }catch (Exception e){
      log.error("更新教师信息异常" + e);
      ExceptionProcessorUtils.wrapperHandlerException(response,e);
      e.printStackTrace();
    }
    return response;
  }

  @Override
  public TeacherRestateResponse teacherRestate(TeacherRestateRequest request) {
    TeacherRestateResponse response = new TeacherRestateResponse();
    try{
      int update = teacherAccountMapper.updateState(request.getState(), request.getTeacherId());
      if (update != 1){
        throw new BizException(UserResultCode.TEACHER_ACCOUNT_RESTATE_ERR.getCode());
      }
      response.setCode(UserResultCode.SUCCESS.getCode());
      response.setMsg(UserResultCode.SUCCESS.getMessage());
    }catch (Exception e){
      log.error("重置教师账号状态失败");
      ExceptionProcessorUtils.wrapperHandlerException(response,e);
      e.printStackTrace();
    }
    return response;
  }

  @Override
  public TeacherResetResponse resetPwd(TeacherResetRequest request) {
    TeacherResetResponse response = new TeacherResetResponse();
    try {
      int update = teacherAccountMapper.updatePwd(request.getPassword(),
          request.getTeacherId());
      if (update != 1){
        throw new BizException(UserResultCode.TEACHER_PWD_RESET_ERR.getCode());
      }
      response.setCode(UserResultCode.SUCCESS.getCode());
      response.setMsg(UserResultCode.SUCCESS.getMessage());
    }catch (Exception e){
      log.error("重置教师密码错误");
      ExceptionProcessorUtils.wrapperHandlerException(response,e);
      e.printStackTrace();
    }
    return response;
  }


}


