package com.privalue.user.dal.persistence;

import com.privalue.commons.tool.tkmapper.TkMapper;
import com.privalue.user.dal.entitys.TeacherAccount;

public interface TeacherAccountMapper extends TkMapper<TeacherAccount> {

    int insert(TeacherAccount teacherAccount);

    int insertSelective(TeacherAccount record);

    int updateByPrimaryKeySelective(TeacherAccount record);

    int updateByPrimaryKey(TeacherAccount record);
}
