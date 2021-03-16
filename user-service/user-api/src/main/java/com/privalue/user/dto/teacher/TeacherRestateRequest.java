package com.privalue.user.dto.teacher;

import com.privalue.commons.result.AbstractRequest;
import lombok.Data;

/**
 * description:
 * date: 2021/3/16 14:53   By HuTianYu
 */

@Data
public class TeacherRestateRequest extends AbstractRequest {

  private Integer teacherId;

  private String state;

  @Override
  public void requestCheck() {

  }
}


