package com.osp.testwebservice.services.impl;


import com.osp.testwebservice.entity.LicInfoNetworkType;
import com.osp.testwebservice.repository.LicInfoNetworkTypeRepository;
import com.osp.testwebservice.services.LicInfoNetworkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LicInfoNetworkServiceImpl implements LicInfoNetworkService {
    private final LicInfoNetworkTypeRepository licInfoNetworkTypeRepository;

    @Override
    public List<LicInfoNetworkType> saveLicInfoNetworkTypes(List<LicInfoNetworkType> licInfoNetworkTypes){
        return  licInfoNetworkTypeRepository.saveAll(licInfoNetworkTypes);
    }
}
