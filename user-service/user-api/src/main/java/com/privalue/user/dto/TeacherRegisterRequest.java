package com.privalue.user.dto;

import com.privalue.commons.result.AbstractRequest;
import com.privalue.commons.tool.exception.ValidateException;
import com.privalue.user.constants.UserResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

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

  private String school;

  private String phoneNumber;

  private String remark;

  @Override
  public void requestCheck() {
    if (StringUtils.isBlank(teacherCode)||StringUtils.isBlank(teacherName)){
      throw new ValidateException(UserResultCode.REQUEST_CHECK_FAILURE.getCode(),
                                  UserResultCode.REQUEST_CHECK_FAILURE.getMessage());
    }

  }
}


