/**
 * ++ giens Product ++
 */
package com.gicore.common.common.site;

import com.gicore.common.common.AbstractCommonService;
import com.gicore.common.common.file.FileManagerService;
import com.gicore.common.util.ApplicationResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SiteBannerImageService extends AbstractCommonService<SiteBannerImage> {
    private final FileManagerService fileManagerService;
    private final SiteBannerImageMapper siteBannerImageMapper;
    private final SiteBannerImageRepository siteBannerImageRepository;
    private final MessageSource messageSource;

    private String getMessage(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

    @Override
    protected List<SiteBannerImage> selectPage(SiteBannerImage request) throws Exception {
        return siteBannerImageMapper.SELECT_PAGE(request);
    }

    @Override
    protected int selectPagingTotalNumber(SiteBannerImage request) throws Exception {
        return siteBannerImageMapper.SELECT_PAGING_TOTAL_NUMBER(request);
    }

    @Override
    protected List<SiteBannerImage> findImpl(SiteBannerImage request) throws Exception {
        return siteBannerImageMapper.SELECT(request);
    }

    public List<Map<String, Object>> findWithFile(SiteBannerImage request) throws Exception {
        List<Map<String, Object>> list = siteBannerImageMapper.SELECT_WITH_FILE(request);
        for (Map<String, Object> banner : list) {
            Map<String, Object> param = new HashMap<>();
            String baseUrl = ApplicationResource.get("application.properties").get("imgPath").toString();
            param.put("BASE_URL", baseUrl);
            param.put("file_path", banner.get("file_path"));
            param.put("file_id", banner.get("file_id") + "." + banner.get("file_extension")); // TODO file_extension 을 따로 보내는 메소드를 만드는게 좋겠다

            banner.put("file_url", fileManagerService.getImage(param));
        }
        return list;
    }

    @Override
    protected int removeImpl(SiteBannerImage request) {
        return siteBannerImageMapper.DELETE(request);
    }

    @Transactional(rollbackFor = Exception.class)
    protected int removeAndShift(SiteBannerImage request) {
        int result = siteBannerImageMapper.DELETE(request);

        if (result == 1) {
            siteBannerImageMapper.SHIFT(request.getBanner_image_number());
        }

        return result;
    }

    @Override
    protected int updateImpl(SiteBannerImage request) {
        return siteBannerImageMapper.UPDATE(request);
    }

    public int reorder(List<SiteBannerImage> request) {
        return siteBannerImageMapper.REORDER(request);
    }

    @Override
    protected int registerImpl(SiteBannerImage request) {
        return siteBannerImageMapper.INSERT(request);
    }
}