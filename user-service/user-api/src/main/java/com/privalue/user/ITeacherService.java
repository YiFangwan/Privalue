package com.privalue.user;

import com.privalue.user.dto.teacher.*;

/**
 * description:
 * date: 2021/2/25 19:36   By HuTianYu
 */

public interface ITeacherService {
  TeacherInfoResponse getTeacherInfo(TeacherInfoRequest request);

  TeacherRegisterResponse register(TeacherRegisterRequest request);

  TeacherDeleteResponse delete(Integer id);

  TeacherListResponse getTeacherList();

  TeacherModifyResponse teacherModify(TeacherModifyRequest request);

  TeacherRestateResponse teacherRestate(TeacherRestateRequest request);

  TeacherResetResponse resetPwd(TeacherResetRequest request);
}
