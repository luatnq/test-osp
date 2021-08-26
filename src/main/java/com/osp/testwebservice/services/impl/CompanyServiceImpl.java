package com.osp.testwebservice.services.impl;

import com.osp.testwebservice.entity.Company;
import com.osp.testwebservice.repository.CompanyRepository;
import com.osp.testwebservice.services.CompanyService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public List<Company> getCompanyByIds(List<Integer> ids){
        List<Company> companies = companyRepository.getCompanyByIdIn(ids);
        return companies;
    }
}
