package com.privalue.user.dto.teacher;

import com.privalue.commons.result.AbstractRequest;
import lombok.Data;

/**
 * description:
 * date: 2021/3/16 15:34   By HuTianYu
 */

@Data
public class TeacherResetRequest extends AbstractRequest {

  private String password;

  private String teacherId;

  @Override
  public void requestCheck() {

  }
}


