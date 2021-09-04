package com.osp.testwebservice.services.impl;


import com.osp.testwebservice.entity.CpnRevenue;
import com.osp.testwebservice.model.request.RequestDTO;
import com.osp.testwebservice.repository.CompanyRevenueRepository;
import com.osp.testwebservice.services.CpnRevenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CpnRevenueServiceImpl implements CpnRevenueService {

    private final CompanyRevenueRepository companyRevenueRepository;

    @Override
    public CpnRevenue getCpnRevenuesByCpnId(Date dateReq, Integer cpnIdReq, String typeReq, int quarterReq, long year) {
        CpnRevenue cpnRevenues = companyRevenueRepository.
                getCpnRevenueByCompanyIdAndDate(cpnIdReq, dateReq, typeReq, quarterReq, year).orElse(null);
        return cpnRevenues;
    }
}
