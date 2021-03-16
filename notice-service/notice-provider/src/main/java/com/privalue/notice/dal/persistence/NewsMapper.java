package com.privalue.notice.dal.persistence;

import com.privalue.notice.dal.entitys.News;
import com.privalue.notice.dto.news.NewsDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer newsId);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer newsId);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    int selectCount(String state);

    List<NewsDto> selectAll(String state);

    int updateStateByPrimaryKey(@Param("newsId") Integer newsId,@Param("state") String state);

    int selectCountByKeyword(@Param("keyword") String keyword, @Param("state") String state);

    List<NewsDto> selectByKeyword(@Param("keyword") String keyword,@Param("state") String state);
}
