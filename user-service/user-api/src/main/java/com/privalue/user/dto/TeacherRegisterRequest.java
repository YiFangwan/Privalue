package com.privalue.user.dto;

import com.privalue.commons.result.AbstractRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description: 教师注册
 * date: 2021/3/5 11:21   By HuTianYu
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherRegisterRequest extends AbstractRequest {

  private String teacherCode;

  private String teacherName;

  private Integer gender;

  private Integer age;

  private String nation;

  private String phoneNumber;

  private String remark;

  @Override
  public void requestCheck() {

  }
}


