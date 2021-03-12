package com.privalue.notice.dal.persistence;

import com.privalue.notice.dal.entitys.Notice;
import com.privalue.notice.dto.NoticeDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeMapper {
    int deleteByPrimaryKey(Integer noticeId);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer noticeId);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);

    List<NoticeDto> selectAll();

    int updateStateByPrimaryKey(@Param("noticeId")Integer noticeId,@Param("state") String state);
}
