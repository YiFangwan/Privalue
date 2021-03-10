package com.privalue.user.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * description:
 * date: 2021/3/6 15:39   By HuTianYu
 */

@Data
public class TeacherListDto implements Serializable {

  private Integer id;

  private String teacherCode;

  private String teacherName;

  private String phoneNumber;

}


