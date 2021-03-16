package com.privalue.user.dto.teacher;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * description:
 * date: 2021/3/6 15:39   By HuTianYu
 */

@Data
public class TeacherListDto implements Serializable {

  private Integer id;

  private String teacherCode;

  private String teacherName;

  private Integer gender;

  private Integer age;

  private String nation;

  private String phoneNumber;

  private Date updateDate;

  private String email;

  private String department;

  private String position;

}


