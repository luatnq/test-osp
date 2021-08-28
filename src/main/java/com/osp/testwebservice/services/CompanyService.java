package com.osp.testwebservice.services;

import com.osp.testwebservice.model.request.RequestDTO;
import com.osp.testwebservice.model.response.CompanyInfoDTO;
import com.osp.testwebservice.model.response.PageRes;

import java.text.ParseException;

public interface CompanyService {
    PageRes getCompanyInfo(int page, int size, RequestDTO requestDTO) throws ParseException;
}
