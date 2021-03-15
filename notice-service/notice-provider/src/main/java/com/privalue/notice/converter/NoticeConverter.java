package com.privalue.notice.converter;

import com.privalue.notice.dal.entitys.Notice;
import com.privalue.notice.dto.notice.NoticeCreateRequest;
import com.privalue.notice.dto.notice.NoticeModifyRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

/**
 * description:
 * date: 2021/3/12 16:45   By HuTianYu
 */

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NoticeConverter {

  @Mappings({
      @Mapping(source = "title",target = "title"),
      @Mapping(source = "content",target = "content"),
      @Mapping(source = "beginDate",target = "beginDate"),
      @Mapping(source = "endDate",target = "endDate")})
  Notice req2Notice(NoticeCreateRequest request);

  @Mappings({
      @Mapping(source = "noticeId",target = "noticeId"),
      @Mapping(source = "title",target = "title"),
      @Mapping(source = "content",target = "content"),
      @Mapping(source = "beginDate",target = "beginDate"),
      @Mapping(source = "endDate",target = "endDate")})
  Notice req2Notice(NoticeModifyRequest request);




}
