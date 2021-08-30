package com.osp.testwebservice.services;

import com.osp.testwebservice.entity.LicInfo;
import com.osp.testwebservice.model.response.LicInfoRes;

import java.util.Date;
import java.util.List;

public interface LicInfoService {
    List<LicInfoRes> getLicInfoRes(int companyId, long year, int quarter, String type, Date date);
    List<LicInfo> saveAllLicInfo(List<LicInfo> licInfos);
}
