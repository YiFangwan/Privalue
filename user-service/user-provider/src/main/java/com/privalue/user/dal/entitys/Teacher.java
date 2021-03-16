package com.privalue.user.dal.entitys;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "teacher")
@ToString
public class Teacher {

    @Id
    private Integer id;

    private String teacherCode;

    private String teacherName;

    private Integer gender;

    private Integer age;

    private String school;

    private String nation;

    private String phoneNumber;

    private String email;

    private String department;

    private String position;

    private Date createDate;

    private Date updateDate;

    private String remark;

    private Boolean deleteFlag;
}
