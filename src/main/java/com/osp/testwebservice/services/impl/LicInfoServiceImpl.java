package com.osp.testwebservice.services.impl;

import com.osp.testwebservice.entity.CpnRevenue;
import com.osp.testwebservice.entity.LicInfo;
import com.osp.testwebservice.model.request.RequestDTO;
import com.osp.testwebservice.model.response.LicInfoRes;
import com.osp.testwebservice.repository.CompanyRevenueRepository;
import com.osp.testwebservice.repository.LicInfoRepository;
import com.osp.testwebservice.services.CpnRevenueService;
import com.osp.testwebservice.services.LicInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LicInfoServiceImpl implements LicInfoService {

    private final LicInfoRepository licInfoRepository;
    private final CpnRevenueService cpnRevenueService;


    @Override
    public List<LicInfoRes> getLicInfoRes(int companyId, long year, int quarter, String type, Date date) {
        List<LicInfo> licInfos = this.getLicInfosByCpnId(companyId, date);
        List<LicInfoRes> licInfoResList = new ArrayList<>();
        CpnRevenue cpnRevenue = cpnRevenueService.getCpnRevenuesByCpnId(date, companyId, type, quarter, year);
        if (Objects.nonNull(cpnRevenue)) {
            licInfoResList = this.buildLicInfoResList(licInfos, cpnRevenue);
        }
        return licInfoResList;
    }

    @Override
    public List<LicInfo> saveAllLicInfo(List<LicInfo> licInfos) {
        return licInfoRepository.saveAll(licInfos);
    }

    private List<LicInfo> getLicInfosByCpnId(Integer id, Date date) {
        List<LicInfo> licInfos = licInfoRepository.getLicInfos(id, date);
        return licInfos;
    }

    private List<LicInfoRes> buildLicInfoResList(List<LicInfo> licInfos, CpnRevenue cpnRevenue) {

        List<LicInfoRes> licInfoResList = new ArrayList<>();
        for (LicInfo t : licInfos) {
            LicInfoRes licInfoRes = new LicInfoRes();
            licInfoRes.setLicNumber(t.getLicNumber());
            licInfoRes.setLicNetworkType(t.getLicInfoNetworkType().getNetworkType().getAlias());
            licInfoRes.setRevenue(cpnRevenue.getRevenue());
            licInfoResList.add(licInfoRes);
        }
        return licInfoResList;
    }
}
