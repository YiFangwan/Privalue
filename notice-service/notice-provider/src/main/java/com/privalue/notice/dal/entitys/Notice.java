package com.privalue.notice.dal.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
    private Integer noticeId;

    private String title;

    private String content;

    private String state;

    @JsonFormat(timezone = "CST")
    private Date beginDate;

    @JsonFormat(timezone = "CST")
    private Date endDate;

    private Integer creator;

    @JsonFormat(timezone = "CST")
    private Date updateDate;
}
