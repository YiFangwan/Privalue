package com.privalue.user.dto.teacher;

import com.privalue.commons.result.AbstractRequest;
import lombok.Data;

/**
 * description: 删除教师
 * date: 2021/3/5 20:00   By HuTianYu
 */

@Data
public class TeacherDeleteRequest extends AbstractRequest {

  private Integer id;

  @Override
  public void requestCheck() {

  }
}


