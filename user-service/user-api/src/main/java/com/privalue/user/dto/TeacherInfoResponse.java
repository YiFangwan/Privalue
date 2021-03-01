package com.privalue.user.dto;

import com.privalue.commons.result.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * description:
 * date: 2021/2/26 14:32   By HuTianYu
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherInfoResponse extends AbstractResponse {
  private Integer id;

  private String teacherCode;

  private String teacherName;

  private String gender;

  private String age;

  private String nation;

  private String phoneNumber;

  private Date createDate;

  private Date updateDate;

  private String remark;

}


