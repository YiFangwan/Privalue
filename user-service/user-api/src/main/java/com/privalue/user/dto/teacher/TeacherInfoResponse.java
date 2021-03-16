package com.privalue.user.dto.teacher;

import com.privalue.commons.result.AbstractResponse;
import lombok.Data;

import java.util.Date;

/**
 * description:
 * date: 2021/2/26 14:32   By HuTianYu
 */

@Data
public class TeacherInfoResponse extends AbstractResponse {

  private Integer id;

  private String teacherCode;

  private String teacherName;

  private Integer gender;

  private Integer age;

  private String nation;

  private String phoneNumber;

  private Date createDate;

  private Date updateDate;

  private String remark;

  private Boolean deleteFlag;

}


