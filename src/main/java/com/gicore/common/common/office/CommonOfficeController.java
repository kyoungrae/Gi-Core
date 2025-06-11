package com.gicore.common.common.office;

import com.gicore.common.common.AbstractCommonController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/common/common/commonOffice")
@RequiredArgsConstructor
public class CommonOfficeController extends AbstractCommonController<CommonOffice> {

	private final CommonOfficeService commonOfficeService;
    private final CommonOfficeRepository commonOfficeRepository;

	@PostMapping("/findPage")
    public Map<String,List<?>> findPage(@RequestBody CommonOffice reqeust) throws Exception{
        return commonOfficeService.findPage(reqeust);
    }

    @PostMapping("/findAll")
    protected List<CommonOffice> findAll(@RequestBody CommonOffice request) throws Exception{
        return commonOfficeRepository.findAll();
    }

    @PostMapping("/find")
    @Override
    protected List<CommonOffice> findImpl(@RequestBody CommonOffice request) throws Exception{
        return commonOfficeService.findImpl(request);
    }

    @PostMapping("/remove")
    @Override
    protected int removeImpl(@RequestBody CommonOffice request) {
        return commonOfficeService.removeImpl(request);
    }

    @PostMapping("/update")
    @Override
    protected int updateImpl(@RequestBody CommonOffice request) {
        return commonOfficeService.updateImpl(request);
    }

    @PostMapping("/register")
    @Override
    protected int registerImpl(@RequestBody CommonOffice request) {
        return commonOfficeService.registerImpl(request);
    }
}