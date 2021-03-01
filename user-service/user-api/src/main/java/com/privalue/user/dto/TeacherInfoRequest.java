package com.privalue.user.dto;

import com.privalue.commons.result.AbstractRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:
 * date: 2021/2/26 14:39   By HuTianYu
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherInfoRequest extends AbstractRequest {

  private Integer teacherId;

  @Override
  public void requestCheck() {

  }

}


