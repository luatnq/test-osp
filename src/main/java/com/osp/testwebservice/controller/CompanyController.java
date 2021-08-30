package com.osp.testwebservice.controller;


import com.osp.testwebservice.model.request.RequestDTO;
import com.osp.testwebservice.model.response.PageRes;
import com.osp.testwebservice.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
        return companyService.getCompanyInfo(page, size, requestDTO);
    }

    @PostMapping(path = "upload")
    public Object importXlsCompanyInfo(@RequestParam("company_id") Integer companyId,
                                       @RequestParam("file") MultipartFile file) throws IOException, ParseException {
        return companyService.importXls(file, companyId);

    }
}
