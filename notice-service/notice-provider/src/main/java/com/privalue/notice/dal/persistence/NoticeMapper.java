package com.privalue.notice.dal.persistence;

import com.privalue.notice.dal.entitys.Notice;
import com.privalue.notice.dto.notice.NoticeDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeMapper {
    int deleteByPrimaryKey(Integer noticeId);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer noticeId);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);

    List<NoticeDto> selectAll(String state);

    int updateStateByPrimaryKey(@Param("noticeId")Integer noticeId,@Param("state") String state);

    int selectCount(String state);

    int selectCountByKeyword(@Param("keyword")String keyword,@Param("state") String state);

    List<NoticeDto> selectByKeyword(@Param("keyword")String keyword,@Param("state") String state);
}
