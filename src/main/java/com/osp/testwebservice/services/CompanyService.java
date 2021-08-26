package com.osp.testwebservice.services;

import com.osp.testwebservice.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getCompanyByIds(List<Integer> ids);
}
