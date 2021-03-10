package com.privalue.user.dal.persistence;

import com.privalue.user.dal.entitys.StudentAccount;

public interface StudentAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentAccount record);

    int insertSelective(StudentAccount record);

    StudentAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentAccount record);

    int updateByPrimaryKey(StudentAccount record);
}