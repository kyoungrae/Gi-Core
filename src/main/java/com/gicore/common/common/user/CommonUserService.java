/**
 *  ++ giens Product ++
 */
package com.gicore.common.common.user;

import com.gicore.common.common.AbstractCommonService;
import com.gicore.common.common.site.SiteConfigService;
import com.gicore.common.common.usergroup.CommonUserGroup;
import com.gicore.common.common.usergroup.CommonUserGroupMapper;
import com.gicore.common.exception.CustomException;
import com.gicore.common.util.ApplicationResource;
import com.gicore.common.util.passwordvalidation.PasswordPolicy;
import com.gicore.common.util.passwordvalidation.PasswordValidationUtil;
import com.gicore.common.util.validation.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CommonUserService extends AbstractCommonService<User> {
    private final CommonUserMapper commonUserMapper;
    private final CommonUserRepository commonUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final CommonUserGroupMapper commonUserGroupMapper;
    private final MessageSource messageSource;
    private final SiteConfigService siteConfigService;

    private String getMessage(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }
    public Map<String, List<?>> findPage(CommonUser request) throws Exception {
        List<CommonUser> list = new ArrayList<>();
        Map<String, List<?>> result = new HashMap<>();
        int pagingNum;
        try {
            list = selectPage(request);
            pagingNum = selectPagingTotalNumber(request);

            List<Integer> pagingList = new ArrayList<>();
            pagingList.add(pagingNum);

            result.put("DATA", list);
            result.put("TOTAL_PAGING", pagingList);
        } catch (Exception e) {
            throw new Exception(e);
        }
        return result;
    }
    public Map<String, List<?>> findJoinCommonUserGroupPage(CommonUser request) throws Exception {
        List<CommonUser> list = new ArrayList<>();
        Map<String, List<?>> result = new HashMap<>();
        int pagingNum;
        try {
            list = selectJoinCommonUserGroupPage(request);
            pagingNum = selectJoinCommonUserGroupPagingTotalNumber(request);

            List<Integer> pagingList = new ArrayList<>();
            pagingList.add(pagingNum);

            result.put("DATA", list);
            result.put("TOTAL_PAGING", pagingList);
        } catch (Exception e) {
            throw new Exception(e);
        }
        return result;
    }
    protected List<CommonUser> selectJoinCommonUserGroupPage(CommonUser request) throws Exception {
        return commonUserMapper.SELECT_JOIN_COMMON_USER_GROUP_PAGE(request);
    }
    protected int selectJoinCommonUserGroupPagingTotalNumber(CommonUser request) throws Exception {
        return commonUserMapper.SELECT_JOIN_COMMON_USER_GROUP_PAGING_TOTAL_NUMBER(request);
    }
    public Map<String, List<?>> findJoinInspectionStationInspectorPage(CommonUser request) throws Exception {
        List<CommonUser> list = new ArrayList<>();
        Map<String, List<?>> result = new HashMap<>();
        int pagingNum;
        try {
            list = selectJoinInspectionStationInspectorPage(request);
            pagingNum = selectJoinInspectionStationInspectorPagingTotalNumber(request);

            List<Integer> pagingList = new ArrayList<>();
            pagingList.add(pagingNum);

            result.put("DATA", list);
            result.put("TOTAL_PAGING", pagingList);
        } catch (Exception e) {
            throw new Exception(e);
        }
        return result;
    }
    protected List<CommonUser> selectJoinInspectionStationInspectorPage(CommonUser request) throws Exception {
        return commonUserMapper.SELECT_JOIN_INSPECTION_STATION_INSPECTOR_PAGE(request);
    }
    protected int selectJoinInspectionStationInspectorPagingTotalNumber(CommonUser request) throws Exception {
        return commonUserMapper.SELECT_JOIN_INSPECTION_STATION_INSPECTOR__PAGING_TOTAL_NUMBER(request);
    }
    protected List<CommonUser> selectPage(CommonUser request) throws Exception {
        return commonUserMapper.SELECT_PAGE(request);
    }
    protected int selectPagingTotalNumber(CommonUser request) throws Exception {
        return commonUserMapper.SELECT_PAGING_TOTAL_NUMBER(request);
    }
    @Override
    protected List<User> selectPage(User request) throws Exception {
        return commonUserMapper.SELECT_PAGE(request);
    }

    @Override
    protected int selectPagingTotalNumber(User request) throws Exception {
        return commonUserMapper.SELECT_PAGING_TOTAL_NUMBER(request);
    }
    @Override
    protected List<User> findImpl(User request) throws Exception {
        return commonUserMapper.SELECT(request);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    protected int removeImpl(User request) throws Exception {
        int rtn = 0;
        try {
            var commonUserGroupBean = CommonUserGroup.builder()
                    .user_email(request.getEmail())
                    .build();
            rtn = commonUserGroupMapper.SELECT(commonUserGroupBean).size();
            if(rtn > 0 ){
                throw new CustomException(getMessage("EXCEPTION.FAIL.REMOVE.USER.EXIST.EMAIL.USER_GROUP"));
            }
            rtn = removeToken(request);
            if(rtn > 0){
                rtn = removeUser(request);
            }
        } catch (Exception e) {
            throw new Exception(e + ": Fail to Remove User and Token");
        }
        return rtn;
    }
    @Transactional(rollbackFor = Exception.class)
    protected int removeToken(User request) throws Exception {
        int rtn = 0;
        try {
            rtn = commonUserMapper.DELETE_TOKEN(request);
        } catch (Exception e) {
            throw new Exception(e + ": Fail to Remove Token");
        }
        return rtn;
    }

    @Transactional(rollbackFor = Exception.class)
    protected int removeUser(User request) throws Exception {
        int rtn = 0;
        try {
            rtn = commonUserMapper.DELETE(request);
        } catch (Exception e) {
            throw new Exception(e + ": Fail to Remove User");
        }
        return rtn;
    }

    @Override
    protected int updateImpl(User request) {
        ValidationService validationService = new ValidationService();
        boolean flag = validationService.checkEmptyValue(request.getPassword());
        if(flag){
            List<String> failReasons = validatePasswordPolicy(request.getPassword());
            if (failReasons.size() > 0) {
                throw new CustomException(failReasons.get(0));
            }
            request.setPassword(passwordEncoder.encode(request.getPassword()));
        }
        return commonUserMapper.UPDATE(request);
    }

    @Override
    protected int registerImpl(User request) {
        List<String> failReasons = validatePasswordPolicy(request.getPassword());
        if (failReasons.size() > 0) {
            throw new CustomException(failReasons.get(0));
        }

        return commonUserMapper.INSERT(request);
    }

    public boolean matchToPassword(CommonUser request){
        var userBean = User.builder()
                .id(request.getId())
                .build();
        List<User> userList = commonUserMapper.SELECT(userBean);
        String before_password_encoded = userList.get(0).getPassword();
        return passwordEncoder.matches(request.getBefore_password(),before_password_encoded);
    }

    public String getUserImageUrlByUserEmail(String email) {
        // TODO 이미지 호출 방식이 변경되면 여기도 바껴야 함
        String fileName = commonUserMapper.GET_USER_IMAGE_FILE_NAME_BY_EMAIL(email);
        if(fileName == null || fileName.isEmpty()){
            return ""; // return null을 하면 에러나서 빈값 리턴
        }
        String imagePath = ApplicationResource.get("application.properties").get("imgPath").toString();
        String filePath = ApplicationResource.get("application.properties").get("filePath").toString();
        return imagePath + "?fileId=" + fileName + "&basePath=" + filePath + "/userImgFolder";
    }

    public int changePassword(CommonUser request) {
        User param = new User();
        param.setEmail(request.getEmail());
        List<User> users = commonUserMapper.SELECT(param);

        if (users == null || users.isEmpty() || users.size() != 1) {
            throw new UsernameNotFoundException("NO_USER");
        }

        List<String> failReasons = validatePasswordPolicy(request.getPassword());
        if (failReasons.size() > 0) {
            throw new CustomException(failReasons.get(0));
        }

        if (!passwordEncoder.matches(request.getBefore_password(), users.get(0).getPassword())) {
            throw new CustomException("NOT_MATCH_PASSWORD");
        }

        User user = new User();
        user.setId(users.get(0).getId());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return commonUserMapper.UPDATE(user);
    }

    public List<String> validatePasswordPolicy(String newPassword) {
        PasswordPolicy policy = siteConfigService.getPasswordPolicy();
        PasswordValidationUtil passwordValidationUtil = new PasswordValidationUtil();
        return passwordValidationUtil.validatePassword(newPassword, policy);
    }

    public int initializePassword(CommonUser request) {
        User param = new User();
        param.setEmail(request.getEmail());
        List<User> users = commonUserMapper.SELECT(param);

        if (users == null || users.isEmpty() || users.size() != 1) {
            throw new UsernameNotFoundException("NO_USER");
        }

        List<String> failReasons = validatePasswordPolicy(request.getPassword());
        if (failReasons.size() > 0) {
            throw new CustomException(failReasons.get(0));
        }

        User user = new User();
        user.setId(users.get(0).getId());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return commonUserMapper.UPDATE(user);
    }
}