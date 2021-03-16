package com.privalue.user.dto.teacher;

import com.privalue.commons.result.AbstractRequest;
import lombok.Data;

/**
 * description:
 * date: 2021/3/16 13:50   By HuTianYu
 */

@Data
public class TeacherModifyRequest extends AbstractRequest {

  private Integer id;

  private String teacherCode;

  private String teacherName;

  private Integer gender;

  private Integer age;

  private String nation;

  private String school;

  private String phoneNumber;

  private String remark;

  @Override
  public void requestCheck() {


  }
}


