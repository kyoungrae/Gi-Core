package com.gicore.common.common.popup;

import com.gicore.common.common.AbstractCommonController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/common/common/commonPopup")
@RequiredArgsConstructor
public class CommonPopupController extends AbstractCommonController<CommonPopup> {

	private final CommonPopupService commonPopupService;
    private final CommonPopupRepository commonPopupRepository;

	@PostMapping("/findPage")
    public Map<String,List<?>> findPage(@RequestBody CommonPopup reqeust) throws Exception{
        return commonPopupService.findPage(reqeust);
    }

    @PostMapping("/findAll")
    protected List<CommonPopup> findAll(@RequestBody CommonPopup request) throws Exception{
        return commonPopupRepository.findAll();
    }

    @PostMapping("/find")
    @Override
    protected List<CommonPopup> findImpl(@RequestBody CommonPopup request) throws Exception{
        return commonPopupService.findImpl(request);
    }

    @PostMapping("/remove")
    @Override
    protected int removeImpl(@RequestBody CommonPopup request) {
        return commonPopupService.removeImpl(request);
    }

    @PostMapping("/update")
    @Override
    protected int updateImpl(@RequestBody CommonPopup request) {
        return commonPopupService.updateImpl(request);
    }

    @PostMapping("/register")
    @Override
    protected int registerImpl(@RequestBody CommonPopup request) {
        return commonPopupService.registerImpl(request);
    }

    @PostMapping("/findCommonPopup")
    protected List<CommonPopup> findCommonPopup(@RequestBody CommonPopup request) throws Exception{
        return commonPopupService.findCommonPopup(request);
    }
}