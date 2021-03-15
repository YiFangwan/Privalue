package com.privalue.notice.dal.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {
    private Integer newsId;

    private String title;

    private String content;

    private String state;

    private Date beginDate;

    private Date endDate;

    private Integer creator;

    private Date updateDate;
}
