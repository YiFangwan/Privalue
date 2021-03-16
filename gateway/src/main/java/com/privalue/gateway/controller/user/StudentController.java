package com.privalue.gateway.controller.user;

import com.privalue.commons.result.ResponseData;
import com.privalue.user.IStudentService;
import com.privalue.user.dto.student.*;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

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
    // TODO: 2021/3/10
//    studentService.getStudentInfo(request.getId())
    return null;
  }

  @GetMapping("/studentList")
  public ResponseData getStudentList(){
    // TODO: 2021/3/16
    return null;
  }

  @PostMapping("/register")
  public ResponseData register(@RequestBody StudentRegisterRequest request){
    // TODO: 2021/3/16
    return null;
  }

  @DeleteMapping("/delete")
  public ResponseData studentDelete(StudentDeleteRequest request){
    studentService.deleteStudent(request);
    return null;
  }

  @PostMapping("/modify")
  public ResponseData studentModify(@RequestBody StudentModifyRequest request){
    // TODO: 2021/3/16
    return null;
  }

  @PutMapping("resetPwd")
  public ResponseData studentReset(StudentResetRequest request){
    // TODO: 2021/3/16
    return null;
  }

}


