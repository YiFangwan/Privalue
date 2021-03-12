package com.privalue.notice;

import com.privalue.notice.dto.*;

/**
 * description:
 * date: 2021/3/11 13:47   By HuTianYu
 */

public interface INoticeService {
  NoticeListResponse getNoticeList(NoticeListRequest request);

  NoticePauseResponse pausePublish(NoticePauseRequest request);

  NoticeDeleteResponse deleteNotice(NoticeDeleteRequest request);

  NoticeCreateResponse createNotice(NoticeCreateRequest request);
}
