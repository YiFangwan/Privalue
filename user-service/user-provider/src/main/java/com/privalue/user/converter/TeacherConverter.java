package com.privalue.user.converter;

import com.privalue.user.dal.entitys.Teacher;
import com.privalue.user.dto.teacher.TeacherInfoResponse;
import com.privalue.user.dto.teacher.TeacherListDto;
import com.privalue.user.dto.teacher.TeacherModifyRequest;
import com.privalue.user.dto.teacher.TeacherRegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

/**
 * description:
 * date: 2021/3/4 16:39   By HuTianYu
 */

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeacherConverter {

  @Mappings({
      @Mapping(source = "id",target = "id"),
      @Mapping(source = "teacherCode",target = "teacherCode")})
  TeacherInfoResponse teacher2Res(Teacher teacher);

  @Mappings({})
  Teacher req2Teacher(TeacherRegisterRequest registerRequest);

  @Mappings({
      @Mapping(source = "gender",target = "gender"),
      @Mapping(source = "age",target = "age"),
      @Mapping(source = "nation",target = "nation"),
      @Mapping(source = "department",target = "department"),
      @Mapping(source = "position",target = "position"),
      @Mapping(source = "phoneNumber",target = "phoneNumber")
  })
  TeacherListDto teacher2List(Teacher teacher);

  @Mappings({})
  Teacher req2Teacher(TeacherModifyRequest request);

}
