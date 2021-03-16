package com.privalue.user;

import com.privalue.user.dto.student.StudentDeleteRequest;
import com.privalue.user.dto.student.StudentDeleteResponse;

/**
 * description:
 * date: 2021/2/25 19:40   By HuTianYu
 */

public interface IStudentService {

  StudentDeleteResponse deleteStudent(StudentDeleteRequest request);
}
