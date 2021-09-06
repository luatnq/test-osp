package com.osp.testwebservice.services;

import com.osp.testwebservice.model.request.RequestCompanyInfo;
import com.osp.testwebservice.model.response.PageRes;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;

public interface CompanyService {
    PageRes getCompanyInfo(int page, int size, RequestCompanyInfo requestCompanyInfo) throws ParseException;

    Object importXls(MultipartFile multipartFile, int companyId) throws IOException, ParseException;
}
