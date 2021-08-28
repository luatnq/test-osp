package com.osp.testwebservice.controller;


import com.osp.testwebservice.model.request.RequestDTO;
import com.osp.testwebservice.model.response.PageRes;
import com.osp.testwebservice.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/")
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping(path = "search")
    public PageRes getCompanies(@RequestParam("page") int page,
                                @RequestParam("size") int size,
                                @RequestBody RequestDTO requestDTO) throws ParseException {
        return companyService.getCompanyInfo(page, size,requestDTO);
    }
}
