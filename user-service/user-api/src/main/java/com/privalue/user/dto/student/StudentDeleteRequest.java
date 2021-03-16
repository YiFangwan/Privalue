package com.privalue.user.dto.student;

import com.privalue.commons.result.AbstractRequest;
import lombok.Data;

/**
 * description:
 * date: 2021/3/16 19:39   By HuTianYu
 */

@Data
public class StudentDeleteRequest extends AbstractRequest {

  private Integer studentId;

  @Override
  public void requestCheck() {

  }
}


