package com.osp.testwebservice.services;

import com.osp.testwebservice.entity.LicInfoNetworkType;

import java.util.List;

public interface LicInfoNetworkService {
    List<LicInfoNetworkType> saveLicInfoNetworkTypes(List<LicInfoNetworkType> licInfoNetworkTypes);
}
