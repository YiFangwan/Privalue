package com.privalue.user.services;

import com.privalue.user.IStudentService;
import com.privalue.user.dal.persistence.StudentAccountMapper;
import com.privalue.user.dal.persistence.StudentMapper;
import com.privalue.user.dto.student.StudentDeleteRequest;
import com.privalue.user.dto.student.StudentDeleteResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * description:
 * date: 2021/3/15 9:09   By HuTianYu
 */

@Slf4j
@Component
@Service
public class StudentServiceImpl implements IStudentService {

  @Autowired
  StudentMapper studentMapper;

  @Autowired
  StudentAccountMapper studentAccountMapper;


  @Override
  public StudentDeleteResponse deleteStudent(StudentDeleteRequest request) {
    StudentDeleteResponse response = new StudentDeleteResponse();
    // TODO: 2021/3/16
    return null;


  }
}


