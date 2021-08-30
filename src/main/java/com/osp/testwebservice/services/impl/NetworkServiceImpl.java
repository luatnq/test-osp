package com.osp.testwebservice.services.impl;

import com.osp.testwebservice.entity.NetworkType;
import com.osp.testwebservice.repository.NetworkTypeRepository;
import com.osp.testwebservice.services.NetworkTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NetworkServiceImpl implements NetworkTypeService {
    private final NetworkTypeRepository networkTypeRepository;

    @Override
    public NetworkType getNetworkType(String alias){
        NetworkType networkType = networkTypeRepository.getNetworkTypeByAlias(alias);
        return networkType;
    }
}
