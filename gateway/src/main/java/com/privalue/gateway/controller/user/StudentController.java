package com.privalue.gateway.controller.user;

import com.privalue.commons.result.ResponseData;
import com.privalue.user.IStudentService;
import com.privalue.user.dto.StudentInfoRequest;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 * date: 2021/3/8 10:37   By HuTianYu
 */

@Slf4j
@RestController
@RequestMapping("/user/student")
@Api(tags = "StudentController",description = "学生控制层")
public class StudentController {

  @Reference(timeout = 30000,check = false)
  IStudentService studentService;

  @GetMapping("/studentInfo")
  public ResponseData getStudentInfo(StudentInfoRequest request){
//    studentService.getStudentInfo(request.getId())
    return null;

  }
}


