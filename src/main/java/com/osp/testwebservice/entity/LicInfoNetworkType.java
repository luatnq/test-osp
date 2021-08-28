package com.osp.testwebservice.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "lic_info_network_type")
public class LicInfoNetworkType implements Serializable {

    @Id
    @Column(name = "lic_cnp_id")
    private Integer id;

    @OneToOne(mappedBy = "licInfoNetworkType")
    @MapsId
    @JoinColumn(name = "lic_cnp_id")
    @JsonIgnore
    private LicInfo licInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "network_type_id", nullable = false)
    private NetworkType networkType;
}
