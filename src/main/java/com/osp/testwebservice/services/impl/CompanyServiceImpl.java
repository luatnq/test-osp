package com.osp.testwebservice.services.impl;

import com.osp.testwebservice.entity.Company;
import com.osp.testwebservice.entity.LicInfo;
import com.osp.testwebservice.entity.LicInfoNetworkType;
import com.osp.testwebservice.entity.NetworkType;
import com.osp.testwebservice.model.CompanyInfoItem;
import com.osp.testwebservice.model.TelcoPeriod;
import com.osp.testwebservice.model.request.RequestDTO;
import com.osp.testwebservice.model.response.LicInfoRes;
import com.osp.testwebservice.model.response.CompanyInfoDTO;
import com.osp.testwebservice.model.response.PageRes;
import com.osp.testwebservice.repository.CompanyRepository;
import com.osp.testwebservice.services.*;
import com.osp.testwebservice.utils.ReadXLSHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final LicInfoService licInfoService;
    private final CpnRevenueService cpnRevenueService;
    private final NetworkTypeService networkTypeService;
    private final LicInfoNetworkService licInfoNetworkService;

    @Override
    public PageRes getCompanyInfo(int page, int size, RequestDTO requestDTO) throws ParseException {
        PageRes pageRes = new PageRes();
        String typeReq = requestDTO.getType();
        long yearReq = requestDTO.getYear();
        int quarterReq = requestDTO.getQuarter();
        Date dateReq = requestDTO.getDate();
        List<Integer> companyIds = requestDTO.getCompanyIds();
        List<CompanyInfoDTO> companyInfoDTOs = new ArrayList<>();
        List<CompanyInfoDTO> companyInfoDTOsRes = new ArrayList<>();
        TelcoPeriod telcoPeriod = new TelcoPeriod(typeReq, yearReq, quarterReq);
        int fromNum = page * size;
        int toNum = (page + 1) * size;

        for (Integer id : companyIds) {
            Company company = companyRepository.getCompanyById(id);
            List<LicInfoRes> licInfoRes = licInfoService.getLicInfoRes(id, yearReq, quarterReq, typeReq, dateReq);
            CompanyInfoDTO companyInfoDTO = this.buildCompanyInfo(dateReq, company, licInfoRes, telcoPeriod);
            companyInfoDTOs.add(companyInfoDTO);
        }
        int n = companyInfoDTOs.size();
        if (toNum > n) toNum = n;

        for (int i = fromNum; i < toNum; i++) {
            companyInfoDTOsRes.add(companyInfoDTOs.get(i));
        }
        int totalRecord = companyInfoDTOs.size();
        if (totalRecord % size == 0) {
            pageRes.setTotalPages(totalRecord / size);
        } else {
            pageRes.setTotalPages((totalRecord / size) + 1);
        }
        pageRes.setPageNumber(page);
        pageRes.setTotal(totalRecord);
        pageRes.setPageSize(size);
        pageRes.setContent(companyInfoDTOsRes);

        return pageRes;
    }

    @Override
    public Object importXls(MultipartFile file, int companyId) throws IOException, ParseException {

        Company company = companyRepository.findById(companyId).orElse(null);

        List<LicInfo> licInfos = new ArrayList<>();
        List<LicInfoNetworkType> licInfoNetworkTypes = new ArrayList<>();
        List<CompanyInfoItem> companyInfoItems = ReadXLSHelper.readXLSCompanyInfo(file.getInputStream(), companyId);
        for (CompanyInfoItem item : companyInfoItems) {
            if (item.getStt() >= 1) {
                LicInfo licInfo = new LicInfo(item.getFromYear(), item.getToYear(), item.getLicNumber(), company);
                licInfos.add(licInfo);
                NetworkType networkType = networkTypeService.getNetworkType(item.getTypeLic());
                LicInfoNetworkType licInfoNetworkType = new LicInfoNetworkType(licInfo, networkType);
                licInfoNetworkTypes.add(licInfoNetworkType);
            }
        }
        licInfoService.saveAllLicInfo(licInfos);
        licInfoNetworkService.saveLicInfoNetworkTypes(licInfoNetworkTypes);

        return companyInfoItems;
    }

    private CompanyInfoDTO buildCompanyInfo(Date date, Company company,
                                            List<LicInfoRes> licInfoRes,
                                            TelcoPeriod telcoPeriod) {

        CompanyInfoDTO companyInfoDTO = new CompanyInfoDTO();
        companyInfoDTO.setCompanyId(company.getId());
        companyInfoDTO.setCompanyName(company.getName());
        companyInfoDTO.setCompanyCode(company.getCode());
        companyInfoDTO.setTelcoPeriod(telcoPeriod);
        companyInfoDTO.setLicInfoRes(licInfoRes);
        companyInfoDTO.setInfoDate(date);
        return companyInfoDTO;
    }


}
