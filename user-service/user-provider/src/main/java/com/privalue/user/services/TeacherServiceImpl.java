package com.privalue.user.services;

import com.privalue.user.ITeacherService;
import com.privalue.user.constants.UserResultCode;
import com.privalue.user.converter.TeacherConverter;
import com.privalue.user.dal.entitys.Teacher;
import com.privalue.user.dal.persistence.TeacherAccountMapper;
import com.privalue.user.dal.persistence.TeacherMapper;
import com.privalue.user.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

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
    TeacherRegisterResponse teacherRegisterResponse = new TeacherRegisterResponse();
    Teacher teacher = teacherConverter.req2Teacher(request);
    int insert = teacherMapper.insert(teacher);
    if (insert == 1){
      teacherRegisterResponse.setCode(UserResultCode.SUCCESS.getCode());
      teacherRegisterResponse.setMsg(UserResultCode.SUCCESS.getMessage());
    }else {
      teacherRegisterResponse.setCode(UserResultCode.TEACHER_REGISTER_ERROR.getCode());
      teacherRegisterResponse.setMsg(UserResultCode.TEACHER_REGISTER_ERROR.getMessage());
    }
    return teacherRegisterResponse;
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
    example.selectProperties("id","teacherCode","teacherName","phoneNumber")
        .createCriteria().andEqualTo("deleteFlag",0);
    List<Teacher> teachers = teacherMapper.selectByExample(example);
    List<TeacherListDto> teacherListDtos = teacherConverter.teacher2List(teachers);
    TeacherListResponse teacherListResponse = new TeacherListResponse();
    teacherListResponse.setTeacherListDtos(teacherListDtos);
    return teacherListResponse;
  }
}


