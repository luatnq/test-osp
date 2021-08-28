//package com.osp.testwebservice.model.dtos;
//
//import com.osp.testwebservice.entity.LicInfo;
//import com.osp.testwebservice.entity.NetworkType;
//
//import javax.persistence.*;
//
//public class LicInfoNetworkTypeDTO {
//    private Integer id;
//
//    @OneToOne
//    @MapsId
//    @JoinColumn(name = "lic_cnp_id")
//    private LicInfo licInfo;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "network_type_id", nullable = false)
//    private NetworkType networkType;
//}
