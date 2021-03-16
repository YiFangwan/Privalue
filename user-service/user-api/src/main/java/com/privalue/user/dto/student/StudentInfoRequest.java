package com.privalue.user.dto.student;

import com.privalue.commons.result.AbstractRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description: 请求学生信息
 * date: 2021/3/8 17:36   By HuTianYu
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentInfoRequest extends AbstractRequest {

  private Integer id;

  @Override
  public void requestCheck() {

  }
}


