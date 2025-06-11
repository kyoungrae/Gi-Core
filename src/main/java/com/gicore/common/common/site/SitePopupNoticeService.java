/**
 *  ++ giens Product ++
 */
package com.gicore.common.common.site;

import com.gicore.common.common.AbstractCommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SitePopupNoticeService extends AbstractCommonService<SitePopupNotice> {
    private final SitePopupNoticeMapper sitePopupNoticeMapper;
    private final SitePopupNoticeTargetGroupMapper sitePopupNoticeTargetGroupMapper;
    private final SitePopupNoticeRepository sitePopupNoticeRepository;
    private final MessageSource messageSource;

     private String getMessage(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

    @Override
    protected List<SitePopupNotice> selectPage(SitePopupNotice request) throws Exception {
        return sitePopupNoticeMapper.SELECT_PAGE(request);
    }

    @Override
    protected int selectPagingTotalNumber(SitePopupNotice request) throws Exception {
        return sitePopupNoticeMapper.SELECT_PAGING_TOTAL_NUMBER(request);
    }
    @Override
    protected List<SitePopupNotice> findImpl(SitePopupNotice request) throws Exception {
        return sitePopupNoticeMapper.SELECT(request);
    }
    protected List<Map<String, Object>> selectNoticeWithTargetGroup(SitePopupNotice request) throws Exception {
        return sitePopupNoticeMapper.SELECT_NOTICE_WITH_TARGET_GROUP(request);
    }

    protected List<Map<String, Object>> findNoticeByUserGroup(SitePopupNotice request) throws Exception {
        return sitePopupNoticeMapper.SELECT_NOTICE_BY_USER_GROUP(request);
    }

    @Override
    protected int removeImpl(SitePopupNotice request) {
        return sitePopupNoticeMapper.DELETE(request);
    }

    @Override
    protected int updateImpl(SitePopupNotice request) {
        return sitePopupNoticeMapper.UPDATE(request);
    }

    @Override
    protected int registerImpl(SitePopupNotice request) throws Exception {
        return sitePopupNoticeMapper.INSERT(request);
     }

    @Transactional
    public int registerNoticeWithTargetGroup(SitePopupNotice request) throws Exception {
        int result = 0;

        try {
            // 1. Notice INSERT
            sitePopupNoticeMapper.INSERT(request);
            String noticeId = request.getNotice_id();

            // 2. Target Group INSERT
            List<SitePopupNoticeTargetGroup> targetGroups = new ArrayList<>();
            for (String id : request.getTarget_group_list()) {
                SitePopupNoticeTargetGroup group = new SitePopupNoticeTargetGroup();
                group.setSystem_create_userid(request.getSystem_create_userid());
                group.setNotice_id(noticeId);
                group.setGroup_id(id);
                targetGroups.add(group);
            }

            // Target Group을 모두 INSERT
            int targetGroupInsertCount = sitePopupNoticeTargetGroupMapper.INSERT_ALL(targetGroups);

            // INSERT가 정상적으로 처리되면 result를 1로 설정
            if (targetGroupInsertCount > 0) {
                result = 1;
            } else {
                result = -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = -1;
        }
        return result;
    }


    @Transactional
    public int updateNoticeWithTargetGroup(SitePopupNotice request) throws Exception {
        int result = 0;

        // 1. Notice UPDATE
        sitePopupNoticeMapper.UPDATE(request);

        // 2. Target Group DELETE
        SitePopupNoticeTargetGroup target = new SitePopupNoticeTargetGroup();
        target.setNotice_id(request.getNotice_id());
        sitePopupNoticeTargetGroupMapper.DELETE(target);

        // 3. -> INSERT
        List<SitePopupNoticeTargetGroup> targetGroups = new ArrayList<>();
        for (String id : request.getTarget_group_list()) {
            SitePopupNoticeTargetGroup group = new SitePopupNoticeTargetGroup(); // 새로 생성
            group.setNotice_id(request.getNotice_id());
            group.setSystem_create_userid(request.getSystem_update_userid());
            group.setGroup_id(id);
            targetGroups.add(group);
        }

        sitePopupNoticeTargetGroupMapper.INSERT_ALL(targetGroups);

        return result;
    }

}