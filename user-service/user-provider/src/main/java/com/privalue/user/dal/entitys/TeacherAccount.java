package com.privalue.user.dal.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherAccount {

    @Id
    private Integer id;

    private Integer teacherId;

    private String account;

    private String password;

    private String accState;

    private Date createDate;

    private Date updateDate;

    private boolean deleteFlag;
}
