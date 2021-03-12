package com.privalue.user.dal.persistence;

import com.privalue.commons.tool.tkmapper.TkMapper;
import com.privalue.user.dal.entitys.StudentAccount;

public interface StudentAccountMapper extends TkMapper<StudentAccount> {

    int insert(StudentAccount record);

    int insertSelective(StudentAccount record);

    int updateByPrimaryKeySelective(StudentAccount record);

    int updateByPrimaryKey(StudentAccount record);
}
