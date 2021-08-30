package com.osp.testwebservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "LIC_INFO")
@AllArgsConstructor
@NoArgsConstructor
public class LicInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "effect_date")
    private Date effectDate;

    @Column(name = "expired_date")
    private Date expiredDate;

    @Column(name = "expired_time")
    private Date expiredTime;

    @Column(name = "lic_number")
    private String licNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @LazyToOne(LazyToOneOption.NO_PROXY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", nullable = true)
    private LicInfo licInfo;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private LicInfoNetworkType licInfoNetworkType;

    public LicInfo(Date fromDate, Date toDate, String licNumber , Company company){
        this.createdTime = new Date();
        this.effectDate = fromDate;
        this.expiredDate = toDate;
        this.licNumber = licNumber;
        this.company = company;
    }
}
