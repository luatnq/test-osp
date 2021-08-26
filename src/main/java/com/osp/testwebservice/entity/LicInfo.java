package com.osp.testwebservice.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;
import java.util.List;

@Entity
@Data
@Table(name = "LIC_INFO")
public class LicInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_time")
    private Instant createdTime;

    @Column(name = "effect_date")
    private String effectDate;

    @Column(name = "expired_date")
    private String expiredDate;

    @Column(name = "expired_time")
    private String expiredTime;

    @Column(name = "lic_number")
    private String licNumber;

    @ManyToOne()
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", nullable = true)
    private LicInfo licInfo;

    @OneToMany(mappedBy = "licInfo")
    private List<LicInfo> licInfos;

    @OneToOne(mappedBy = "licInfo", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private LicInfoNetworkType licInfoNetworkType;
}