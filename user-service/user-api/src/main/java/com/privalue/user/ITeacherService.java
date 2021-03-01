package com.privalue.user;

import com.privalue.user.dto.TeacherInfoRequest;
import com.privalue.user.dto.TeacherInfoResponse;

/**
 * description:
 * date: 2021/2/25 19:36   By HuTianYu
 */

public interface ITeacherService {
  TeacherInfoResponse getTeacherList(TeacherInfoRequest request);
}
