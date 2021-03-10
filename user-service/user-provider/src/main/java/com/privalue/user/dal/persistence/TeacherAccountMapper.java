package com.privalue.user.dal.persistence;

import com.privalue.user.dal.entitys.TeacherAccount;

public interface TeacherAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeacherAccount record);

    int insertSelective(TeacherAccount record);

    TeacherAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeacherAccount record);

    int updateByPrimaryKey(TeacherAccount record);
}