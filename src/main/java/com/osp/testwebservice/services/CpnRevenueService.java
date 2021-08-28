package com.osp.testwebservice.services;

import com.osp.testwebservice.entity.CpnRevenue;

import java.util.Date;
import java.util.List;

public interface CpnRevenueService {
    CpnRevenue getCpnRevenuesByCpnId(Date dateReq, Integer cpnIdReq,
                                     String typeReq, int quarterReq,
                                     long year);
}
