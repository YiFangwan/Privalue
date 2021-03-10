package com.privalue.user.dal.entitys;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "student")
@ToString
public class Student {

    @Id
    private Integer id;

    private String stuCode;

    private String stuName;

    private Object gender;

    private Integer age;

    private String school;

    private Date createDate;

    private Date updateDate;

    private String remark;

    private String nation;

    private Byte deleteFlag;
}
