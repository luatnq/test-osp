package com.osp.testwebservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Entity
@Data
@Table(name = "cpn_revenue")
public class CpnRevenue implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "last_modified_time")
    private Instant lastModifiedTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Column(name = "type")
    private String type;

    @Column(name = "quarter")
    private int quarter;

    @Column(name = "year")
    private int year;

    @Column(name = "reason")
    private String reason;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "revenue")
    private Integer revenue;

}
