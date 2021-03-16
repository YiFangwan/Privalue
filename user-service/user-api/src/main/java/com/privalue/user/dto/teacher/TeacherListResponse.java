package com.privalue.user.dto.teacher;

import com.privalue.commons.result.AbstractResponse;
import lombok.Data;

import java.util.List;

/**
 * description: 返回教师列表
 * date: 2021/2/25 19:37   By HuTianYu
 */

@Data
public class TeacherListResponse extends AbstractResponse {

  private List<TeacherListDto> teacherListDtos;

}


