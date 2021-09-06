package com.osp.testwebservice.controller;


import com.osp.testwebservice.model.request.RequestCompanyInfo;
import com.osp.testwebservice.model.response.PageRes;
import com.osp.testwebservice.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/")
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping(path = "search-info")
    public ResponseEntity<PageRes> getCompanies(@RequestParam("page") int page,
                                                @RequestParam("size") int size,
                                                @RequestBody RequestCompanyInfo requestCompanyInfo) throws ParseException {
        PageRes pageRes = companyService.getCompanyInfo(page, size, requestCompanyInfo);
        return new ResponseEntity <>(pageRes, HttpStatus.OK);
    }

    @PostMapping(path = "upload-info")
    public ResponseEntity<Object> importXlsCompanyInfo(@RequestParam("company_id") Integer companyId,
                                       @RequestParam("file") MultipartFile file) throws IOException, ParseException {
        Object objRes = companyService.importXls(file, companyId);
        return new ResponseEntity<>(objRes, HttpStatus.OK);
    }
}
