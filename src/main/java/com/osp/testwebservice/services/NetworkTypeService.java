package com.osp.testwebservice.services;

import com.osp.testwebservice.entity.NetworkType;

import java.util.Optional;

public interface NetworkTypeService {
    NetworkType getNetworkType(String alias);
}
