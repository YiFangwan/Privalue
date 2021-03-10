package com.privalue.user.converter;

import com.privalue.user.dal.entitys.Teacher;
import com.privalue.user.dto.TeacherInfoResponse;
import com.privalue.user.dto.TeacherListDto;
import com.privalue.user.dto.TeacherRegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * description:
 * date: 2021/3/4 16:39   By HuTianYu
 */

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeacherConverter {

  @Mappings({
      @Mapping(source = "id",target = "id"),
      @Mapping(source = "teacherCode",target = "teacherCode")
  })
  TeacherInfoResponse teacher2Res(Teacher teacher);

  @Mappings({})
  Teacher req2Teacher(TeacherRegisterRequest registerRequest);

  @Mappings({})
  List<TeacherListDto> teacher2List(List<Teacher> teacherList);


}
