package com.privalue.user.dal.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentAccount {

    @Id
    private Integer id;

    private Integer studentId;

    private String account;

    private String password;

    private String state;

    private Date createDate;

    private Date updateDate;

    private String deleteFlag;
}
