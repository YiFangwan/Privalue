package com.privalue.user.dal.persistence;

import com.privalue.commons.tool.tkmapper.TkMapper;
import com.privalue.user.dal.entitys.TeacherAccount;
import org.apache.ibatis.annotations.Param;

public interface TeacherAccountMapper extends TkMapper<TeacherAccount> {

  int insert(TeacherAccount teacherAccount);

  int insertSelective(TeacherAccount record);

  int updateByPrimaryKeySelective(TeacherAccount record);

  int updateByPrimaryKey(TeacherAccount record);

  int updateState(@Param("state") String state, @Param("id") Integer teacherId);

  int updatePwd(@Param("pwd") String password,@Param("id") String teacherId);
}
